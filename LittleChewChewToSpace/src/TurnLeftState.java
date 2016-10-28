import lejos.nxt.Motor;

public class TurnLeftState  extends State{

	private int _moveSpeed = 2000;
	
	@Override
	public void OnStateEnter() {
		Motor.A.setSpeed(_moveSpeed);
	}

	@Override
	public void OnStateUpdate(float dt) {
		
		System.out.println("Updating");
		Motor.A.forward();
	}

	@Override
	public void OnStateExit() {
		Motor.A.setSpeed(0);
	}

}
