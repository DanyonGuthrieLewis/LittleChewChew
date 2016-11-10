
public class BoundaryEvent extends Event{
	private boolean isOnBoundary;
	private boolean isNotOnBoundary;
	private boolean isInBoundary;
	private boolean isOutOfBoundary;
	public BoundaryEvent(boolean OnBoundary, boolean OutOfBoundary){
		Tag = "BoundaryCrossed";
		isOnBoundary = OnBoundary;
		isNotOnBoundary = !OnBoundary;
		isOutOfBoundary = OutOfBoundary;
		isInBoundary = !OutOfBoundary;
	}
	public boolean getIsOnBoundary(){
		return isInBoundary;
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
