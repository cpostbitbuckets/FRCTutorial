package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.drive.DriveSubsystem;

public class Robot extends TimedRobot {

    private DriveSubsystem driveSubsystem;

    @Override
    public void robotInit() {
        super.robotInit();

        driveSubsystem = new DriveSubsystem();
    }

    @Override
    public void disabledInit() {
        super.disabledInit();
    }

}