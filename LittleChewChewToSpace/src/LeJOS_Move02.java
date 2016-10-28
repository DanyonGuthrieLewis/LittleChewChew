

import lejos.nxt.*;

public class LeJOS_Move02 {

	public static void main(String[] args){
		
		StateMachine stateMachine = new StateMachine();
		ForwardState forward = new ForwardState();
		TurnRightState right = new TurnRightState();
		TurnLeftState left = new TurnLeftState();
		TouchSensor touchSensorRight = new TouchSensor(SensorPort.S1);
		TouchSensor touchSensorLeft = new TouchSensor(SensorPort.S2);
		System.out.println("I'm Alive!");
		for(;!Button.ENTER.isDown();){
			if(touchSensorRight.isPressed()){
				if (stateMachine.hasState(right)) stateMachine.removeState(right);
				else stateMachine.addState(right);
				while (touchSensorRight.isPressed()){}
			}
			if(touchSensorLeft.isPressed()){
				if (stateMachine.hasState(left)) stateMachine.removeState(left);
				else stateMachine.addState(left);
				while (touchSensorLeft.isPressed()){}
			}
			stateMachine.update(0);
		}
	}
}
