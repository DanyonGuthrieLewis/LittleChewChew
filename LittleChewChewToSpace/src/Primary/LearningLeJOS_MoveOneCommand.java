package Primary;

import LeJOS_States.ForwardState;
import StateMachine.StateMachine;
import lejos.nxt.*;

public class LearningLeJOS_MoveOneCommand {

	public static void main(String[] args){
		
		StateMachine stateMachine = new StateMachine();
		ForwardState forward = new ForwardState();
		TouchSensor touchSensor = new TouchSensor(SensorPort.S1);
		
		for(;;){
			if(touchSensor.isPressed()){
				if (stateMachine.hasState(forward)) stateMachine.removeState(forward);
				else stateMachine.addState(forward);
				while(touchSensor.isPressed()){}
			}
			stateMachine.update(0);
		}
	}
}
