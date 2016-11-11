package Tests;
import lejos.nxt.ADSensorPort;
import lejos.nxt.TouchSensor;

public class Tester_PushSensor extends TouchSensor {
	private boolean isPressed;
	public Tester_PushSensor(ADSensorPort port) {
		super(port);
	}
	
	@Override
	public boolean isPressed(){
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	

}
