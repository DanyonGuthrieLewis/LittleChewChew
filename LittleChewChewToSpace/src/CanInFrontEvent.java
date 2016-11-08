
public class CanInFrontEvent extends Event{
	boolean isCanInFront;
	public CanInFrontEvent(boolean canInFront){
		Tag = "CanInFront";
		isCanInFront = canInFront;
	}
	public boolean getIsCanInFront(){
		return isCanInFront;
	}
}
