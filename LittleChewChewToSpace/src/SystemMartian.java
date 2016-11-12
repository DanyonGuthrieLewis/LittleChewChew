import lejos.nxt.Sound;

public class SystemMartian{
	private final static int FORWARD_SOUND_CODE = 3;
	private final static int BACKWARD_SOUND_CODE = 2;
	private final static int TOUCHING_SOUND_CODE = 4;
	
	public void playForwardSound(){
		Sound.systemSound(false, FORWARD_SOUND_CODE);
	}
	public void playBackwardSound(){
		Sound.systemSound(false, BACKWARD_SOUND_CODE);
	}
	public void playTouchingSound(){
		Sound.systemSound(false, TOUCHING_SOUND_CODE);
	}
	public void displayMessage(String message){
		System.out.println(message);
	}
}
