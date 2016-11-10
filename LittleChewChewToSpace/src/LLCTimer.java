

public class LLCTimer implements Runnable{
	private long currentTimeInMilliseconds = 0;
	private boolean running = true;
	Thread timerThread;
	@Override
	public void run() {
		while(running){
			trySleep(1);
			++currentTimeInMilliseconds;
		}
	}
	private void trySleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void startTimer(){
		currentTimeInMilliseconds = 0;
		timerThread = new Thread(this, "Timer");
		timerThread.start();
	}
	public void stopTimer(){
		tryWait();
		running = false;
		tryNotify();
	}
	private void tryWait(){
		try {
			timerThread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void tryNotify(){
		timerThread.notify();
	}
	public long getTime(){
		return currentTimeInMilliseconds;
	}
	
}
