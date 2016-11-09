
public class ReverseIntoBoundary extends ObserverState{

	private State locateCan;
	private State backwards;
	private BoundarySystem boundarySystem;
	
	public ReverseIntoBoundary(State locateCan, MoveBackwards backwards, BoundarySystem boundarySystem) {
		this.locateCan = locateCan;
		this.backwards = backwards;
		this.boundarySystem = boundarySystem;
	}
	
	@Override
	public void OnStateEnter() {
		boundarySystem.addObserver(this);
		machine.addState(backwards);
	}
	@Override
	public void OnNotify(Event event) {
		BoundaryCrossedEvent boundaryCrossedEvent = (BoundaryCrossedEvent) event;
		if (boundaryCrossedEvent.getIsInBoundary()){
			machine.switchStates(locateCan, this);
		}
	}
	@Override
	public void OnStateExit() {
		machine.removeState(backwards);
	}

}
