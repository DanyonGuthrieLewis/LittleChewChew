import lejos.nxt.Motor;

public class TurnRightState  extends State{

	private int _moveSpeed = 2000;
	
	@Override
	public void OnStateEnter() {
		Motor.B.setSpeed(_moveSpeed);
	}

	@Override
	public void OnStateUpdate(float dt) {
		
		System.out.println("Updating");
		Motor.B.forward();
	}

	@Override
	public void OnStateExit() {
		Motor.B.setSpeed(0);
	}

}
