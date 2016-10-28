

import lejos.nxt.Motor;

public class ForwardState extends State{

	private int _moveSpeed = 720;
	
	@Override
	public void OnStateEnter() {
		Motor.A.setSpeed(_moveSpeed);
		Motor.B.setSpeed(_moveSpeed);
	}

	@Override
	public void OnStateUpdate(float dt) {
		
		System.out.println("Updating");
		Motor.A.forward();
		Motor.B.forward();
	}

	@Override
	public void OnStateExit() {
		Motor.A.setSpeed(0);
		Motor.B.setSpeed(0);
	}

}
