
public class Finish extends ObserverState{
	private State forward;
	private BoundarySystem boundarySystem;
	
	public void initialize(State forward, BoundarySystem boundarySystem){
		this.boundarySystem = boundarySystem;
		this.forward = forward;
	}
	@Override
	public void OnStateEnter() {
		machine.addState(forward);
		boundarySystem.addObserver(this);
	}
	@Override
	public void OnNotify(Event event) {
		BoundaryEvent boundaryCrossedEvent = (BoundaryEvent) event;
		if (boundaryCrossedEvent.getIsOutOfBoundary()){
			machine.removeState(this);
		}
	}
	@Override
	public void OnStateExit() {
		boundarySystem.removeObserver(this);
		machine.removeState(forward);
	}
}
