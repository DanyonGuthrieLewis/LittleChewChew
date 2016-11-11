
public class LocateSystem extends Observable {
	private IUltrasonicSensor sensor;

	public LocateSystem(IUltrasonicSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public void StartObserving() {
		System.out.println("Observing");
		super.StartObserving();
	}
	
	@Override
	public Event HasChanged() {
		return sensor.hasChanged();
	}

}
