
public class CanInFrontEvent extends Event{
	private boolean isCanInFront;
	public CanInFrontEvent(boolean changed, boolean canInFront){
		Tag = "CanInFront";
		this.changed = changed;
		isCanInFront = canInFront;
	}
	public boolean getIsCanInFront(){
		return isCanInFront;
	}
}
