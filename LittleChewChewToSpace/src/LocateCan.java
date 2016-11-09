
public class LocateCan extends ObserverState{
	private State left;
	private State right;
	private State remove;
	LocateSystem canInFront;
	
	public LocateCan(State remove, State left, State right, LocateSystem canInFront) {
		this.remove = remove;
		this.left = left;
		this.right = right;
		this.canInFront = canInFront;
	}
	
	@Override
	public void OnStateEnter() {
		canInFront.addObserver(this);
		machine.addState(right);
	}
	@Override
	public void OnNotify(Event event) {
		CanInFrontEvent canInFrontEvent = (CanInFrontEvent) event;
		if (canInFrontEvent.getIsCanInFront()){
			machine.switchStates(remove, this);
		}
	}
	@Override
	public void OnStateExit() {
		canInFront.removeObserver(this);
		if (machine.removeState(right)){}
		else machine.removeState(left);
	}

}
