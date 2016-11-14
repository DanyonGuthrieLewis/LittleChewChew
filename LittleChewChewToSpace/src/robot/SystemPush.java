package robot;

public class SystemPush extends Observable{
	private IPushSensor sensor;
	public SystemPush(IPushSensor sensor) {
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
