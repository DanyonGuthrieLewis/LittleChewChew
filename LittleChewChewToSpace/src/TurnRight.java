
public class TurnRight extends State{
	private DriveSystem drive;
	public TurnRight(DriveSystem drive) {
		this.drive = drive;
	}
	
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveRight();
	}
}
