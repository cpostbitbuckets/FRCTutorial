package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Command;

public class DriverControl extends Command {

    private final DriveSubsystem driveSubsystem;

    public DriverControl(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        requires(driveSubsystem);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}