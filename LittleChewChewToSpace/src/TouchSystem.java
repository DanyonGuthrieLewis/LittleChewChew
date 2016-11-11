
public class TouchSystem extends Observable{
	private IPushSensor sensor;
	public TouchSystem(IPushSensor sensor) {
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
