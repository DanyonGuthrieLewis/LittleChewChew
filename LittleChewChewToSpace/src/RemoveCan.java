import lejos.nxt.comm.InBox;

public class RemoveCan extends ObserverState{
	private final int CANS_TO_REMOVE = 3;
	private State locateCan;
	private State forward;
	private State reverse;
	private State finish;
	private LocateSystem locateSystem;
	private BoundarySystem boundarySystem;
	
	private int cansRemoved = 0;
	
	
	public RemoveCan(State locateCan, State forward, State reverse, State finish, LocateSystem locateSystem, BoundarySystem boundrySystem) {
		this.locateCan = locateCan;
		this.forward = forward;
		this.reverse = reverse;
		this.finish = finish;
		this.locateSystem = locateSystem;
		this.boundarySystem = boundrySystem;
	}
	@Override
	public void OnStateEnter() {
		locateSystem.addObserver(this);
		boundarySystem.addObserver(this);
		machine.addState(forward);
	}
	@Override
	public void OnNotify(Event event) {
		if (event.getTag().equals("BoundaryCrossed")){
			BoundaryCrossedEvent boundaryCrossedEvent = (BoundaryCrossedEvent) event;
			if (boundaryCrossedEvent.getIsOutOfBoundary()){
				if (cansRemoved == CANS_TO_REMOVE){
					machine.switchStates(finish, this);
				}
				else machine.switchStates(reverse, this);
			}
		}
		else if (event.getTag().equals("CanInFront")){
			CanInFrontEvent canInFrontEvent = (CanInFrontEvent) event;
			if(!canInFrontEvent.getIsCanInFront()){
				machine.switchStates(locateCan, this);
			}
		}
	}
	@Override
	public void OnStateExit() {
		locateSystem.removeObserver(this);
		boundarySystem.removeObserver(this);
		machine.removeState(forward);
	}
}
