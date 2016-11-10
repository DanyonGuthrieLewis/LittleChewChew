
public class TurnRight extends State{
	private DriveSystem drive;
	public void initialize(DriveSystem drive){
		this.drive = drive;
	}
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveRight();
	}
}
