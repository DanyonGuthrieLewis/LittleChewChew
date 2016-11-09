import lejos.nxt.ADSensorPort;
import lejos.nxt.LightSensor;

public class LeJOS_LightSensor extends LightSensor implements ILightSensor {
	private boolean isWithinBoundary;
	private boolean isNotCrossingBoundary;
	private boolean previousResult;
	private static final int BOUNDARY_VALUE = 50;
	private static final boolean DEFAULT_PREVIOUS_RESULT = false;

	public LeJOS_LightSensor(ADSensorPort port) {
		super(port);
		this.setWithinBoundary(true);
		this.setWithinBoundary(true);
		this.setPreviousResult(DEFAULT_PREVIOUS_RESULT);
	}

	public boolean hasChanged(){
		boolean changed = false;
		boolean currentResult = this.isOutOfBoundary();
		if(currentResult != previousResult){
			changed = true;
		}
		this.setPreviousResult(currentResult);
		return changed;
	}
	public boolean isOutOfBoundary() {
		if(isNotCrossingBoundary){
			if(isOnBoundary()){
				this.setNotCrossingBoundary(false);
			}
		}else{
			if(isNotOnBoundary()){
				this.setNotCrossingBoundary(true);
				this.setWithinBoundary(!this.isWithinBoundary);
			}
		}
		return this.isWithinBoundary;
	}

	public boolean isOnBoundary() {
		int currentValue = readValue();
		return currentValue <= BOUNDARY_VALUE;
	}

	public boolean isNotOnBoundary() {
		return (!isOnBoundary());
	}


	private void setWithinBoundary(boolean isWithinBoundary) {
		this.isWithinBoundary = isWithinBoundary;
	}

	private void setNotCrossingBoundary(boolean isNotCrossingBoundary) {
		this.isNotCrossingBoundary = isNotCrossingBoundary;
	}

	public boolean getPreviousResult() {
		return previousResult;
	}

	public void setPreviousResult(boolean defaultPreviousResult) {
		this.previousResult = defaultPreviousResult;
	}

}
