package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Idle extends Command {

    private final DriveSubsystem driveSubsystem;

    public Idle(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;

        // Use requires() here to declare subsystem dependencies
    	requires(driveSubsystem);
    	setRunWhenDisabled(true);  // Idle state runs when disabled, unlike other states
    }

    @Override
    protected boolean isFinished() {
    	 if(this.driveSubsystem.getRobot().getRunMode() == Robot.RunMode.TELEOP) {
             DriverControl driverControl = new DriverControl(this.driveSubsystem);
             driverControl.start();
         }
    
        // we are not done until the driver takes control
        return false;
    }

}
