package robot;
import java.util.ArrayList;

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
	private State state = State.FORWARD;
	private boolean running = true;
	private boolean active = true;
	private boolean touchingCan = false;
	private int cansRemoved = 0;
	private int cansToRemove = 0;
	
	@Override
	public boolean IsActive() {
		return active;
	}
	private void activate(){
		System.out.println("Activated");
		active = true;
	}
	private void deactivate(){
		System.out.println("Deactivated");
		active = false;
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
		timerSystem = new SystemTimer("TimerEvent");
		finishSystem = new SystemTimer("GetOut");
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
		state = State.TURN_RIGHT;
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
		if(event.getTag().equals("ButtonPressed")){
			System.exit(0);
		}
		else if(event.getTag().equals("BoundaryCrossed")){
			handleBoundaryEvent((EventBoundary) event);
		}
		else if (event.getTag().equals("CanInFront")){
			handleCanInfrontEvent((EventCanInFront) event);
		}
		else if (event.getTag().equals("TouchedCan")){
			handleCanTouchedEvent((EventCanTouched) event);
		}
		else if (event.getTag().equals("TimerEvent") || event.getTag().equals("GetOut")){
			handleTimerEvent((EventTimer) event);
		}
	}
	private void handleBoundaryEvent(EventBoundary event){
		if (state == state.FORWARD){
			if(cansRemoved <= cansToRemove)
			{
				state = State.BACKWARD;
				timerSystem.addObserver(this);
				timerSystem.notifyAfter(150);
				if (touchingCan) System.out.println("Can Removed?");
			}
		}
	}
	private void handleCanInfrontEvent(EventCanInFront event){
		if (state == State.TURN_RIGHT){
			if (event.getIsCanInFront()){
				state = State.FORWARD;
			}
		}
	}
	private void handleCanTouchedEvent(EventCanTouched event){
		touchingCan = event.getIsTouchingCan();
	}
	private void handleTimerEvent(EventTimer event){
		if (event.getTag().equals("TimerEvent")){
			if (state == state.BACKWARD){
				state = State.TURN_RIGHT;
				synchronized(timerSystem){
					timerSystem.removeObserver(this);
				}
			}
		}
		else if (event.getTag().equals("GetOut")){
			synchronized (this) {
				running = false;
			}
		}
	}
	private boolean trySleep(long ms){
		try {
			Thread.sleep(ms);
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
}
