
public class CanTouchedEvent extends Event{
	private boolean isTouchingCan;
	public CanTouchedEvent(boolean changed, boolean touchingCan){
		Tag = "TouchedCan";
		this.changed = changed;
		isTouchingCan = touchingCan;
	}
	public boolean getIsTouchingCan(){
		return isTouchingCan;
	}
}
