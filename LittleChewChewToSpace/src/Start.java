
public class Start extends State{
	private State next;
	public Start(State next){
		this.next = next;
	}
	@Override
	public void OnStateEnter() {
		machine.switchStates(next, this);
	}
}
