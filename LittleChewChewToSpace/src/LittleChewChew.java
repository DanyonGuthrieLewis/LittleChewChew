
public class LittleChewChew {
	
	private StateMachine machine;
	
	LeJOS_UltrasonicSensor ultrasonicSensor;
	LeJOS_PushSensor pushSensor;
	LeJOS_LightSensor lightSensor;
	
	
	private LocateSystem locationSystem;
	private TouchSystem touchSystem;
	private BoundarySystem boundarySystem;
	
	private Start start;
	private LocateCan locateCan;
	private RemoveCan removeCan;
	private ReverseIntoBoundary reverse;
	private Finish finish;
	
	private MoveForwards forward;
	private MoveBackwards backward;
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
		
		
	}
	private void run(){
		
	}
}
