
public class BoundaryEvent extends Event{
	private boolean isOnBoundary;
	private boolean isNotOnBoundary;
	private boolean isInBoundary;
	private boolean isOutOfBoundary;
	public BoundaryEvent(boolean changed, boolean OnBoundary, boolean OutOfBoundary){
		Tag = "BoundaryCrossed";
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
