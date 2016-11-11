import lejos.nxt.TouchSensor;

public class LeJOS_PushSensor implements IPushSensor {
	private boolean previousResult;
	private TouchSensor touchSensor;
	private final boolean DEFAULT_PREVIOUS_RESULT = false;

	public LeJOS_PushSensor(TouchSensor touchSensor) {
		this.setTouchSensor(touchSensor);
		this.setPreviousResult(DEFAULT_PREVIOUS_RESULT);

	}

	@Override
	public boolean isTouchingCan() {
		return touchSensor.isPressed();
	}

	@Override
	public Event hasChanged() {
		boolean changed = false;
		boolean currentResult = isTouchingCan();
		if(currentResult != previousResult){
			changed = true;
		}
		this.setPreviousResult(currentResult);
		return new CanTouchedEvent(changed, isTouchingCan());

	}


	private void setPreviousResult(boolean previousResult) {
		this.previousResult = previousResult;
	}

	public void setTouchSensor(TouchSensor touchSensor) {
		this.touchSensor = touchSensor;
	}
	

}
