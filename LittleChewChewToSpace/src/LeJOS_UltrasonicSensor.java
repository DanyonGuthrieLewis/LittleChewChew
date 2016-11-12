import lejos.nxt.UltrasonicSensor;

public class LeJOS_UltrasonicSensor implements IUltrasonicSensor{
	private boolean previousResult = false;
	private UltrasonicSensor sensor;
	private static final int ACCEPTABLE_RANGE_MIN = 0;
	private static final int ACCEPTABLE_RANGE_MAX = 70;
	
	public LeJOS_UltrasonicSensor(UltrasonicSensor sensor) {
		this.setSensor(sensor);
		this.setPreviousResult(false);
	}

	@Override
	public boolean isCanInFront() {
		int distance = sensor.getDistance();
		return (distance >= ACCEPTABLE_RANGE_MIN && distance <= ACCEPTABLE_RANGE_MAX);
	}

	@Override
	public Event hasChanged() {
		boolean changed = false;
		boolean currentResult = this.isCanInFront();
		if(currentResult != previousResult)
			changed = true;
		this.setPreviousResult(currentResult);
		return new EventCanInFront(changed, isCanInFront(), sensor.getDistance());
	}

	public void setPreviousResult(boolean previousResult) {
		this.previousResult = previousResult;
	}

	public void setSensor(UltrasonicSensor sensor) {
		this.sensor = sensor;
	}

}
