import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class LeJOS_UltrasonicSensor extends UltrasonicSensor implements IUltrasonicSensor{
	private boolean previousResult;
	private static final int ACCEPTABLE_RANGE_MIN = 0;
	private static final int ACCEPTABLE_RANGE_MAX = 0;
	public LeJOS_UltrasonicSensor(I2CPort port) {
		super(port);
		this.setPreviousResult(false);
	}

	@Override
	public boolean isCanInFront() {
		int distance = this.getDistance();
		return (distance >= ACCEPTABLE_RANGE_MIN && distance <= ACCEPTABLE_RANGE_MAX);
	}

	@Override
	public boolean HasChanged() {
		boolean changed = false;
		boolean currentResult = this.isCanInFront();
		if(currentResult != previousResult)
			changed = true;
		this.setPreviousResult(currentResult);
		return changed;
	}

	public void setPreviousResult(boolean previousResult) {
		this.previousResult = previousResult;
	}

}
