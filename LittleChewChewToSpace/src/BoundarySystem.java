
public class BoundarySystem extends Observable{

	ILightSensor sensor;
	public BoundarySystem(ILightSensor sensor) {
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
