import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class LeJOS_UltrasonicSensor extends UltrasonicSensor implements IUltrasonicSensor{
	private static final int ACCEPTABLE_RANGE = 0;
	public LeJOS_UltrasonicSensor(I2CPort port) {
		super(port);
	}

	@Override
	public boolean isCanInFront() {
		int distance = this.getDistance();
		return false;
	}

	@Override
	public boolean HasChanged() {
		// TODO Auto-generated method stub
		return false;
	}

}
