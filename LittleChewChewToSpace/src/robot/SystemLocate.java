package robot;

public class SystemLocate extends Observable {
	private IUltrasonicSensor sensor;

	public SystemLocate(IUltrasonicSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public void StartObserving() {
		super.StartObserving();
	}
	
	@Override
	public Event HasChanged() {
		return sensor.hasChanged();
	}

}
