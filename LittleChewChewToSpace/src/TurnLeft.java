
public class TurnLeft extends State{
	DriveSystem drive;
	public TurnLeft(DriveSystem drive) {
		this.drive = drive;
	}
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveLeft();
	}
}
