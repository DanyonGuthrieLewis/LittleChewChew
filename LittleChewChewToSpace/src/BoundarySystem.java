
public class BoundarySystem extends Observable{

	ILightSensor sensor;
	public BoundarySystem(ILightSensor sensor) {
		this.sensor = sensor;
	}
	@Override
	public boolean HasChanged() {
		return sensor.hasChanged();
	}

}
