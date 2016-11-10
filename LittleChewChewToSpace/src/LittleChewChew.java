import lejos.nxt.SensorPort;

public class LittleChewChew {
	
	//----- State Machine -----//
	private StateMachine machine;
	
	//----- Sensor -----//
	LeJOS_UltrasonicSensor ultrasonicSensor;
	LeJOS_PushSensor pushSensor;
	LeJOS_LightSensor lightSensor;
	
	//----- System -----//
	private LocateSystem locationSystem;
	private TouchSystem touchSystem;
	private BoundarySystem boundarySystem;
	private DriveSystem driveSystem;
	private MartianSystem martianSystem;
	
	
	//----- States -----//
	private Start start = new Start();
	private LocateCan locateCan = new LocateCan();
	private RemoveCan removeCan = new RemoveCan();
	private ReverseIntoBoundary reverse = new ReverseIntoBoundary();
	private Finish finish = new Finish();
	
	private MoveForwards forwards = new MoveForwards();
	private MoveBackwards backwards = new MoveBackwards();
	private TurnLeft left = new TurnLeft();
	private TurnRight right = new TurnRight();
	private TurnLeftUntilBoundary turnLeftUntilBoundary = new TurnLeftUntilBoundary();
	private TurnRightUntilBoundary turnRightUntilBoundary = new TurnRightUntilBoundary();

	
	public void start(){
		initialize();
		run();
	}
	
	private void initialize(){
		machine = new StateMachine();
		initializeSensors();
		initializeSystems();
		initializeStates();
	}
	private void initializeSensors(){
		ultrasonicSensor = new LeJOS_UltrasonicSensor(SensorPort.S1);
		pushSensor = new LeJOS_PushSensor(SensorPort.S2);
		lightSensor = new LeJOS_LightSensor(SensorPort.S3);
	}
	private void initializeSystems(){
		locationSystem = new LocateSystem(ultrasonicSensor);
		touchSystem = new TouchSystem(pushSensor);
		boundarySystem = new BoundarySystem(lightSensor);
		
		locationSystem.StartObserving();
		touchSystem.StartObserving();
		boundarySystem.StartObserving();
	}
	
	private void initializeStates(){
		start.initialize(locateCan);
		locateCan.initialize(removeCan, left, right, locationSystem);
		removeCan.initialize(locateCan, forwards, reverse, finish, locationSystem, boundarySystem);
		reverse.initialize(locateCan, backwards, boundarySystem);
		finish.initialize(forwards, boundarySystem);
		
		forwards.initialize(driveSystem, martianSystem, touchSystem);
		backwards.initialize(driveSystem, martianSystem);
		right.initialize(driveSystem);
		left.initialize(driveSystem);
		turnLeftUntilBoundary.initialize(left, turnRightUntilBoundary, boundarySystem);
		turnRightUntilBoundary.initialize(right, turnLeftUntilBoundary, boundarySystem);
	}
	private void run(){
		LLCTimer timer = new LLCTimer();
		timer.startTimer();
		machine.addState(start);
		while(machine.hasStates()){
			machine.update(0);
		}
		martianSystem.displayMessage("Cleared Cans In " + timer.getTime() + " Seconds!");
	}
}
