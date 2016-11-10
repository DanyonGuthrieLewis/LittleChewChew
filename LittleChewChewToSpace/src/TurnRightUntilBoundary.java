
public class TurnRightUntilBoundary extends ObserverState{
	private State turnRight;
	private State turnLeftUntilBoundary;
	private BoundarySystem boundarySystem;
	public TurnRightUntilBoundary(State turnRight, State turnLeftUntilBoundary, BoundarySystem boundarySystem) {
		this.turnRight = turnRight;
		this.turnLeftUntilBoundary = turnLeftUntilBoundary;
		this.boundarySystem = boundarySystem;
	}
	@Override
	public void OnStateEnter() {
		machine.addState(turnRight);
		boundarySystem.addObserver(this);
	}
	@Override
	public void OnNotify(Event event) {
		BoundaryEvent boundaryCrossedEvent = (BoundaryEvent) event;
		if (boundaryCrossedEvent.getIsOutOfBoundary()){
			machine.switchStates(turnLeftUntilBoundary, this);
		}
	}
	@Override
	public void OnStateExit() {
		boundarySystem.removeObserver(this);
		machine.removeState(turnRight);
	}
}
