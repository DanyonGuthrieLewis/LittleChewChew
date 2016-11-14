package robot;

public class SystemBoundary extends Observable{

	ILightSensor sensor;
	public SystemBoundary(ILightSensor sensor) {
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
