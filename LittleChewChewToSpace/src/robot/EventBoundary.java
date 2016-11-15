package robot;

public class EventBoundary extends Event{
	private boolean isOnBoundary;
	private boolean isNotOnBoundary;
	private boolean isInBoundary;
	private boolean isOutOfBoundary;
	public EventBoundary(boolean changed, boolean OnBoundary, boolean OutOfBoundary){
		handler = RobotEventHandler.BOUNDARY_EVENT;
		this.changed = changed;
		isOnBoundary = OnBoundary;
		isNotOnBoundary = !OnBoundary;
		isOutOfBoundary = OutOfBoundary;
		isInBoundary = !OutOfBoundary;
	}
	public boolean getIsOnBoundary(){
		return isOnBoundary;
	}
	public boolean getIsNotOnBoundary(){
		return isNotOnBoundary;
	}
	public boolean getIsInBoundary(){
		return isInBoundary;
	}
	public boolean getIsOutOfBoundary(){
		return isOutOfBoundary;
	}
}
