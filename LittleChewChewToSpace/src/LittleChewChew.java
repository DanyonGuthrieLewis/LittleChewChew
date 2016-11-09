
public class LittleChewChew {
	
	private StateMachine machine;
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
		
	}
	private void initilaizeSystems(){
		
	}
	private void buildState(){
		locateCan = new LocateCan(removeCan, left, right, locationSystem);
		removeCan = new RemoveCan(locateCan, forward, reverse, locationSystem, boundarySystem);
	}
	private void run(){
		
	}
}
