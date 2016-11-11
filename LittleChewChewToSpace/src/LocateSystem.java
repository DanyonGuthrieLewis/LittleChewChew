
public class LocateSystem extends Observable{
	private IUltrasonicSensor sensor;
	public LocateSystem(IUltrasonicSensor sensor) {
		this.sensor = sensor;
	}
	@Override
	public boolean HasChanged() {
		
		return sensor.hasChanged();
	}

}
