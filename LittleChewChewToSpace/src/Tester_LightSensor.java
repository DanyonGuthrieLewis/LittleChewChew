import lejos.nxt.ADSensorPort;
import lejos.nxt.LightSensor;

public class Tester_LightSensor extends LightSensor {
	private int readValue;
	public Tester_LightSensor(ADSensorPort port) {
		super(port);
	}
	
	@Override
	public int readValue(){
		return readValue;
	}

	public void setReadValue(int readValue) {
		this.readValue = readValue;
	}

}
