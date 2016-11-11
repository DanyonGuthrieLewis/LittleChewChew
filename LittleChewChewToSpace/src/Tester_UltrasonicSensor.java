import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class Tester_UltrasonicSensor extends UltrasonicSensor{
	private int distance;

	public Tester_UltrasonicSensor(I2CPort port) {
		super(port);
	}
	
	@Override
	public int getDistance(){
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	


}
