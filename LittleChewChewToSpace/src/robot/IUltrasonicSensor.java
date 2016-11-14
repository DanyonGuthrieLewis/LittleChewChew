package robot;

public interface IUltrasonicSensor {
	public boolean isCanInFront();

	public Event hasChanged();
}
