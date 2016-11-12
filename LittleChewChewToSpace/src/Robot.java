import java.util.ArrayList;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class Robot implements IObserver{
	
	//----- Sensor -----//
	LeJOS_UltrasonicSensor ultrasonicSensor;
	LeJOS_PushSensor pushSensor;
	LeJOS_LightSensor lightSensor;
	
	//----- System -----//
	private SystemLocate locationSystem;
	private SystemPush touchSystem;
	private SystemBoundary boundarySystem;
	private SystemDrive driveSystem;
	private SystemMartian martianSystem;
	
	//----- Observables -----//
	private SystemButton button = new SystemButton();
	private LLCTimer timer;
	
	public void start(){
		initialize();
		run();
	}
	
	private void initialize(){
		initializeSensors();
		initializeSystems();
	}
	private void initializeSensors(){
		ultrasonicSensor = new LeJOS_UltrasonicSensor(new UltrasonicSensor(SensorPort.S1));
		pushSensor = new LeJOS_PushSensor(new TouchSensor(SensorPort.S2));
		lightSensor = new LeJOS_LightSensor(new LightSensor(SensorPort.S3));
	}
	private void initializeSystems(){
		locationSystem = new SystemLocate(ultrasonicSensor);
		touchSystem = new SystemPush(pushSensor);
		boundarySystem = new SystemBoundary(lightSensor);
		driveSystem = new SystemDrive();
		martianSystem = new SystemMartian();

		locationSystem.StartObserving();
		touchSystem.StartObserving();
		boundarySystem.StartObserving();
		button.StartObserving();
		
		locationSystem.addObserver(this);
		boundarySystem.addObserver(this);
		button.addObserver(this);
	}
	
	private void run(){
		timer = new LLCTimer();
		timer.startTimer();
		
		
	}

	@Override
	public void OnNotify(Event event) {
		System.out.println(event.getTag());
		if(event.getTag().equals("ButtonPressed")){
			System.exit(0);
		}
		else if(event.getTag().equals("BoundaryCrossed")){
			handleBoundaryEvent((EventBoundary) event);
		}
		else if (event.getTag().equals("CanInFront")){
			handleCanInfrontEvent((EventCanInFront) event);
		}
	}
	private void handleBoundaryEvent(EventBoundary event){
		
	}
	private void handleCanInfrontEvent(EventCanInFront event){
		
	}

	@Override
	public boolean IsActive() {
		return true;
	}
}
