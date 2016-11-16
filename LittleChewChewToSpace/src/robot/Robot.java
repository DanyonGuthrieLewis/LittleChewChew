package robot;


import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class Robot implements IObserver{
	
	//----- Sensor -----//
	LeJOS_UltrasonicSensor ultrasonicSensor;
	LeJOS_PushSensor pushSensor;
	LeJOS_LightSensor lightSensor;
	
	//----- System -----//
	private SystemLocate locationSystem;
	private SystemPush touchSystem;
	private SystemBoundary boundarySystem;
	private SystemDrive driveSystem;
	private SystemMartian martianSystem;
	private SystemTimer timerSystem;
	private SystemTimer finishSystem;
	
	//----- Observables -----//
	private SystemButton button = new SystemButton();
	private LLCTimer jobTimer;
	private LLCTimer stateTimer;
	
	//----- Variables -----//
	private Action state = Action.FORWARD;
	private boolean running = true;
	private boolean active = true;
	private boolean touchingCan = false;
	private int cansRemoved = 0;
	private int cansToRemove = 0;
	
	@Override
	public boolean IsActive() {
		return active;
	}
	public void start(){
		initialize();
		run();
	}
	
	private void initialize(){
		initializeSensors();
		initializeSystems();
		initializeTimers();
		observeAll();
		addAllObservers();
	}
	private void initializeSensors(){
		ultrasonicSensor = new LeJOS_UltrasonicSensor(new UltrasonicSensor(SensorPort.S1));
		pushSensor = new LeJOS_PushSensor(new TouchSensor(SensorPort.S2));
		lightSensor = new LeJOS_LightSensor(new LightSensor(SensorPort.S3));
	}
	private void initializeSystems(){
		locationSystem = new SystemLocate(ultrasonicSensor);
		touchSystem = new SystemPush(pushSensor);
		boundarySystem = new SystemBoundary(lightSensor);
		driveSystem = new SystemDrive();
		martianSystem = new SystemMartian();
	}
	private void initializeTimers(){
		jobTimer = new LLCTimer();
		stateTimer = new LLCTimer();
		timerSystem = new SystemTimer(RobotEventHandler.BUFFER_TIMER_EVENT);
		finishSystem = new SystemTimer(RobotEventHandler.FINISH_TIMER_EVENT);
		timerSystem.StartObserving();
		finishSystem.StartObserving();
	}
	private void observeAll(){
		locationSystem.StartObserving();
		touchSystem.StartObserving();
		boundarySystem.StartObserving();
		button.StartObserving();
	}
	private void addAllObservers(){
		locationSystem.addObserver(this);
		touchSystem.addObserver(this);
		boundarySystem.addObserver(this);
		button.addObserver(this);
		finishSystem.addObserver(this);
	}
	private void removeAllObservers(){
		synchronized (locationSystem) {
			locationSystem.removeObserver(this);
		}
		synchronized (touchSystem) {
			touchSystem.removeObserver(this);
		}
		synchronized (boundarySystem) {
			boundarySystem.removeObserver(this);
		}
	}
	
	private void run(){
		jobTimer.startTimer();
		state = Action.TURN_RIGHT;
		stateTimer.startTimer();
		finishSystem.notifyAfter(2500);
		while (running){
			update();
		}
		jobTimer.stopTimer();
		removeAllObservers();
		martianSystem.displayMessage((jobTimer.getTime() / 100) + " Seconds!");
		while (true){
			driveSystem.moveForward();
		}
	}
	private void update(){
		switch (state) {
		case FORWARD:
			driveSystem.moveForward();
			if (touchingCan) martianSystem.playTouchingSound();
			else martianSystem.playForwardSound();
			break;
		case BACKWARD:
			driveSystem.moveBackward();
			martianSystem.playBackwardSound();
			break;
		case TURN_LEFT:
			driveSystem.moveLeft();
			break;
		case TURN_RIGHT:
			driveSystem.moveRight();
			break;
		default:
			break;
		}
	}

	@Override
	public void OnNotify(Event event) {
		Action nextState = event.getHandler().handleEvent(event, state);
		changeState(nextState);
	}
	public void changeState(Action nextState){
		if (nextState == Action.BACKWARD){
			state = Action.BACKWARD;
			timerSystem.addObserver(this);
			timerSystem.notifyAfter(150);
		}
		else if (nextState == Action.FORWARD){
			state = Action.FORWARD;
		}
		else if (nextState == Action.TOUCHING_CAN){
			touchingCan = true;
		}
		else if (nextState == Action.NOT_TOUCHING_CAN){
			touchingCan = false;
		}
		else if (nextState == Action.TURN_RIGHT){
			state = Action.TURN_RIGHT;
			synchronized(timerSystem){
				timerSystem.removeObserver(this);
			}
		}
		else if (nextState == Action.FINISHED){
			synchronized (this) {
				running = false;
			}
		}
		else if (nextState == Action.EXIT){
			System.exit(0);
		}
	}
}
