package robot;

public class EventButtonPress extends Event{

	public EventButtonPress(boolean changed){
		Tag = "ButtonPressed";
		this.changed = changed;
	}
}
