
public class TurnLeftUntilBoundary extends ObserverState{
	private State turnLeft;
	private State turnRightUntilBoundary;
	private BoundarySystem boundarySystem;
	public TurnLeftUntilBoundary(State turnLeft, State turnRightUntilBoundary, BoundarySystem boundarySystem) {
		this.turnLeft = turnLeft;
		this.turnRightUntilBoundary = turnRightUntilBoundary;
		this.boundarySystem = boundarySystem;
	}
	@Override
	public void OnStateEnter() {
		boundarySystem.addObserver(this);
		machine.addState(turnLeft);
	}
	@Override
	public void OnNotify(Event event) {
		BoundaryEvent boundaryCrossedEvent = (BoundaryEvent) event;
		if (boundaryCrossedEvent.getIsOutOfBoundary()){
			machine.switchStates(turnRightUntilBoundary, this);
		}
	}
	@Override
	public void OnStateExit() {
		boundarySystem.removeObserver(this);
		machine.removeState(turnLeft);
	}
}
