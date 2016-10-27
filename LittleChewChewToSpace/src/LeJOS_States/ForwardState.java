package LeJOS_States;

import StateMachine.State;
import lejos.nxt.Motor;

public class ForwardState extends State{

	private int _moveSpeed = 720;
	
	@Override
	public void OnStateEnter() {
		Motor.A.setSpeed(_moveSpeed);
	}

	@Override
	public void OnStateUpdate(float dt) {
		Motor.A.forward();
	}

	@Override
	public void OnStateExit() {
		Motor.A.setSpeed(0);
	}

}
