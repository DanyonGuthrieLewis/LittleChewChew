
public class TouchSystem extends Observable{
	private IPushSensor sensor;
	public TouchSystem(IPushSensor sensor) {
		this.sensor = sensor;
	}
	@Override
	public boolean HasChanged() {
		return sensor.hasChanged();
	}

}
