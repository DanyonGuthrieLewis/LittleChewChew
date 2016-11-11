
public class ReverseIntoBoundary extends ObserverState{

	private State locateCan;
	private State backwards;
	private BoundarySystem boundarySystem;
	
	public void initialize(State locateCan, MoveBackwards backwards, BoundarySystem boundarySystem){
		this.locateCan = locateCan;
		this.backwards = backwards;
		this.boundarySystem = boundarySystem;
	}
	@Override
	public void OnStateEnter() {
		boundarySystem.addObserver(this);
		machine.addState(backwards);
		System.out.println("Reverse");
	}
	@Override
	public void OnNotify(Event event) {
		BoundaryEvent boundaryCrossedEvent = (BoundaryEvent) event;
		if (boundaryCrossedEvent.getIsInBoundary()){
			machine.switchStates(locateCan, this);
		}
	}
	@Override
	public void OnStateExit() {
		machine.removeState(backwards);
	}

}
