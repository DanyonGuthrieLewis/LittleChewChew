package robot;


import lejos.nxt.Button;

public class SystemButton extends Observable{

	private boolean previous = false;
	@Override
	public Event HasChanged() {
		boolean result = false;
		boolean current = Button.ENTER.isDown();
		if (previous != current){
			result = true;
		}
		return new EventButtonPress(result);
	}

}
