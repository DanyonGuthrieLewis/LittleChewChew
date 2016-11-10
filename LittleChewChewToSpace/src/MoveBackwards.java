
public class MoveBackwards extends State{
	private DriveSystem drive;
	private MartianSystem marty;
	
	
	public void initialize(DriveSystem drive, MartianSystem martianSystem){
		this.drive = drive;
		this.marty = martianSystem;
	}
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveBackward();
		marty.playBackwardSound();
	}
}
