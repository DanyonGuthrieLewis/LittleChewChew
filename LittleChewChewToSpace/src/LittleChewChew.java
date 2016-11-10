public class LittleChewChew {
	
	private StateMachine machine;
	
	LeJOS_UltrasonicSensor ultrasonicSensor;
	LeJOS_PushSensor pushSensor;
	LeJOS_LightSensor lightSensor;
	
	private LocateSystem locationSystem;
	private TouchSystem touchSystem;
	private BoundarySystem boundarySystem;
	private DriveSystem driveSystem;
	private MartianSystem martianSystem;
	
	private Start start;
	private LocateCan locateCan;
	private RemoveCan removeCan;
	private ReverseIntoBoundary reverse;
	private Finish finish;
	
	private MoveForwards forward;
	private MoveBackwards backward;
	private TurnLeftUntilBoundary turnLeftUntilBoundary;
	private TurnRightUntilBoundary turnRightUntilBoundary;
	private TurnLeft left;
	private TurnRight right;
	
	public void start(){
		initialize();
		run();
	}
	
	private void initialize(){
		initilaizeSystems();
		buildState();
	}
	private void initilaizeSystems(){
		locationSystem = new LocateSystem(ultrasonicSensor);
		touchSystem = new TouchSystem(pushSensor);
		boundarySystem = new BoundarySystem(lightSensor);
		
		locationSystem.StartObserving();
		touchSystem.StartObserving();
		boundarySystem.StartObserving();
	}
	private void buildState(){
		start = new Start(locateCan);
		locateCan = new LocateCan(removeCan, left, right, locationSystem);
		removeCan = new RemoveCan(locateCan, forward, reverse, finish, locationSystem, boundarySystem);
		reverse = new ReverseIntoBoundary(locateCan, backward, boundarySystem);
		finish = new Finish(forward, boundarySystem);
		
		forward = new MoveForwards(driveSystem, martianSystem, touchSystem);
		backward = new MoveBackwards(driveSystem, martianSystem);
		right = new TurnRight(driveSystem);
		left = new TurnLeft(driveSystem);
		turnLeftUntilBoundary = new TurnLeftUntilBoundary(left, turnRightUntilBoundary, boundarySystem);
		turnRightUntilBoundary = new TurnRightUntilBoundary(right, turnLeftUntilBoundary, boundarySystem);
	}
	private void run(){
		LLCTimer timer = new LLCTimer();
		timer.startTimer();
		while(machine.hasStates()){
			machine.update(0);
		}
		timer.stopTimer();
		martianSystem.displayMessage("Cleared Cans In " + timer.getTime() + " Seconds!");
	}
}
