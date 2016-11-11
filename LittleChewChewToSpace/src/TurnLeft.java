
public class TurnLeft extends State{
	DriveSystem drive;
	
	public void initialize(DriveSystem drive){
		this.drive = drive;
	}
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveLeft();
	}
}
