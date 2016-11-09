import lejos.nxt.ADSensorPort;
import lejos.nxt.TouchSensor;

public class LeJOS_PushSensor extends TouchSensor implements IPushSensor {
	private boolean previousResult;
	private final boolean DEFAULT_PREVIOUS_RESULT = false;

	public LeJOS_PushSensor(ADSensorPort port) {
		super(port);
		this.setPreviousResult(DEFAULT_PREVIOUS_RESULT);

	}

	@Override
	public boolean isTouchingCan() {
		return isPressed();
	}

	@Override
	public boolean hasChanged() {
		boolean changed = false;
		boolean currentResult = isTouchingCan();
		if(currentResult != previousResult){
			changed = true;
		}
		this.setPreviousResult(currentResult);
		return changed;

	}

	public boolean isPreviousResult() {
		return previousResult;
	}

	public void setPreviousResult(boolean previousResult) {
		this.previousResult = previousResult;
	}

}
