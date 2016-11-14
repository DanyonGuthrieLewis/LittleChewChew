package robot;

public class EventCanInFront extends Event{
	private boolean isCanInFront;
	private int distance;
	public EventCanInFront(boolean changed, boolean canInFront, int distance){
		Tag = "CanInFront";
		this.changed = changed;
		isCanInFront = canInFront;
		this.distance = distance;
	}
	public boolean getIsCanInFront(){
		return isCanInFront;
	}
	public int getDistance(){
		return distance;
	}
}
