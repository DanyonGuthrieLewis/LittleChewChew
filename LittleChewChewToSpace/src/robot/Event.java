package robot;

public class Event {
	protected String Tag;
	protected boolean changed = false;
	public String getTag(){
		return Tag;
	}
	public boolean hasChanged(){
		return changed;
	}
}
