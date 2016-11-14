package Tests;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Tester_UltrasonicSensor extends UltrasonicSensor{
	private int distance;

	public Tester_UltrasonicSensor() {
		super(SensorPort.S1);
	}
	
	@Override
	public int getDistance(){
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	


}
