package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.drive.DriveSubsystem;

public class Robot extends TimedRobot {
    // I use the XboxController class, because I have an xbox controller. The stick portions of 
    // this should work with a PS4 controller as well.
    private XboxController driverJoystick;
    private DriveSubsystem driveSubsystem;

    @Override
    public void robotInit() {
        driveSubsystem = new DriveSubsystem();
        // initalize this joystick with Id 0
        driverJoystick = new XboxController(RobotMap.JOYSTICK_DRIVER_ID);
    }

    /**
     * Stop the motors when we disable the robot
     */
    @Override
    public void disabledInit() {
        System.out.println("Robot disabled, stopping motors");
        this.driveSubsystem.stop();
    }

    /**
     * Override teleopPeriodic to get inputs from the joystick and move the robot around with the DriveSubsystem.
     */
    @Override
    public void teleopPeriodic() {
        double forward = -driverJoystick.getY(Hand.kLeft);
        double turn  = driverJoystick.getX(Hand.kRight);

        // System.out.println("tankDrive(" + forward + ", " + turn + ")");
        driveSubsystem.tankDrive(forward, turn);
    }
}