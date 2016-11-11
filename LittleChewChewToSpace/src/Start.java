
public class Start extends State{
	private State next;
	
	public void initialize(State next){
		this.next = next;
	}
	@Override
	public void OnStateEnter() {
		System.out.println("Start");
		machine.switchStates(next, this);
	}
}
