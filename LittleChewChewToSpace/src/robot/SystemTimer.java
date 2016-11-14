package robot;

public class SystemTimer extends Observable{
	String bingbong;
	long startTime = 0;
	long currentTime = 0;
	public SystemTimer(String tag) {
		bingbong = tag;
	}
	public void notifyAfter(long startTime){
		this.startTime = startTime;
		this.currentTime = 0;
	}
	@Override
	public Event HasChanged() {
		++currentTime;
		trySleep(1);
		return new EventTimer(bingbong, (currentTime >= startTime));
	}
	private void trySleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public long getTime(){
		return currentTime;
	}
}
