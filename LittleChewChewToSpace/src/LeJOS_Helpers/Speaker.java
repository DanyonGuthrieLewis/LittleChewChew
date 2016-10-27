package LeJOS_Helpers;

import lejos.nxt.Button;

public class Speaker {
	public void speak() {
		System.out.println("Hello World");
		waitForPress();
	}

	private void waitForPress() {
		Button.waitForAnyPress();
	}
}

