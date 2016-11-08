
public class CanTouchedEvent extends Event{
	boolean isTouchingCan;
	public CanTouchedEvent(boolean touchingCan){
		Tag = "TouchedCan";
		isTouchingCan = touchingCan;
	}
	public boolean getIsTouchingCan(){
		return isTouchingCan;
	}
}
