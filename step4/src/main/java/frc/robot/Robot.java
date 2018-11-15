package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.drive.DriveSubsystem;

public class Robot extends TimedRobot {

    // Use this runMode variable to determine the
	// current running mode of the Robot.
	public enum RunMode { DISABLED, AUTO, TELEOP, TEST };
    private RunMode runMode = RunMode.DISABLED;

    private XboxController driverJoystick;
    private DriveSubsystem driveSubsystem;

    @Override
    public void robotInit() {
        super.robotInit();

        driveSubsystem = new DriveSubsystem(this);
        driverJoystick = new XboxController(RobotMap.JOYSTICK_DRIVER_ID);
    }

    @Override
    public void disabledInit() {
        System.out.println("Disabled");
        this.setRunMode(RunMode.DISABLED);
        super.disabledInit();
    }

    @Override
    public void teleopPeriodic() {
        double forward = -driverJoystick.getY(Hand.kLeft);
        double turn  = driverJoystick.getX(Hand.kRight);

        // System.out.println("tankDrive(" + forward + ", " + turn + ")");
        driveSubsystem.tankDrive(forward, turn);
    }

    /**
     * @return the runMode
     */
    public RunMode getRunMode() {
        return runMode;
    }

    /**
     * @param runMode the runMode to set
     */
    public void setRunMode(RunMode runMode) {
        this.runMode = runMode;
    }


}