package robot;

public interface IPushSensor {
	public boolean isTouchingCan();

	public Event hasChanged();
}
