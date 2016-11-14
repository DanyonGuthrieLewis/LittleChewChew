package Tests;

import lejos.nxt.SensorPort;
import robot.LeJOS_UltrasonicSensor;

public class Test_UltrasonicSensor {
	private static final int MAX_DISTANCE = 170;
	private static final int MIN_DISTANCE = 0;
	private static final int NONE_FOUND = 255;
	private static final int IN_DISTANCE = 25;
	private static final int OUT_DISTANCE = 60;
	private static final int TOTAL_EXPECTED_SUCCESSES = 10;

	public static void main(String[] args) {
		int success = 0;
		Tester_UltrasonicSensor testingSensor = new Tester_UltrasonicSensor(SensorPort.S1);
		LeJOS_UltrasonicSensor sensorClass = new LeJOS_UltrasonicSensor(testingSensor);

		testingSensor.setDistance(MAX_DISTANCE);
		if (sensorClass.isCanInFront() == false)
			++success;
		if (sensorClass.hasChanged().changed() == false)
			++success;

		testingSensor.setDistance(MIN_DISTANCE);
		if (sensorClass.isCanInFront() == true)
			++success;
		if (sensorClass.hasChanged().changed() == true)
			++success;

		testingSensor.setDistance(NONE_FOUND);
		if (sensorClass.isCanInFront() == false)
			++success;
		if (sensorClass.hasChanged().changed() == true)
			++success;

		testingSensor.setDistance(IN_DISTANCE);
		if (sensorClass.isCanInFront() == true)
			++success;
		if (sensorClass.hasChanged().changed() == true)
			++success;

		testingSensor.setDistance(OUT_DISTANCE);
		if (sensorClass.isCanInFront() == true)
			++success;
		if (sensorClass.hasChanged().changed() == false)
			++success;
		
		if(success == TOTAL_EXPECTED_SUCCESSES)
			System.out.println("SUCCESS!!");
		else
			System.out.println("FAILURE.");
	}
}
