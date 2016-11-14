package robot;

public interface ILightSensor {
	public boolean isOnBoundary();
	public boolean isNotOnBoundary();
	public boolean isOutOfBoundary();
	public Event hasChanged();

}
