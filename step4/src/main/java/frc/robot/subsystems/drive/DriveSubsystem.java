package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    private final WPI_TalonSRX leftFrontMotor;
	private final WPI_TalonSRX leftRearMotor;

	private final WPI_TalonSRX rightFrontMotor;
	private final WPI_TalonSRX rightRearMotor;

    /**
     * Constructor for DriveSubsystem. Pass in the robot instance so we can refer to it later.
     */
    public DriveSubsystem() {
        leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_MOTOR_FRONT_ID);
        leftRearMotor = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_MOTOR_REAR_ID);
        
        rightFrontMotor  = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_MOTOR_FRONT_ID);
        rightRearMotor   = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_MOTOR_REAR_ID);
        
        leftFrontMotor.setInverted(RobotMap.LEFT_DRIVE_MOTOR_INVERSION_FLAG);
        leftRearMotor.setInverted(RobotMap.LEFT_DRIVE_MOTOR_INVERSION_FLAG);

        rightFrontMotor.setInverted(RobotMap.RIGHT_DRIVE_MOTOR_INVERSION_FLAG);
        rightRearMotor.setInverted(RobotMap.RIGHT_DRIVE_MOTOR_INVERSION_FLAG);

        // Use follower mode to minimize shearing commands that could occur if
        // separate commands are sent to each motor in a group
        leftRearMotor.follow(leftFrontMotor);
        leftRearMotor.set(ControlMode.Follower, leftFrontMotor.getDeviceID());
        rightRearMotor.follow(rightFrontMotor);        
        rightRearMotor.set(ControlMode.Follower, rightFrontMotor.getDeviceID());
    }

    @Override
    protected void initDefaultCommand() {
        Idle idle = new Idle(this);
        idle.start();
    }

    /**
     * Drive the robot like a tank. This will take two inputs,
     * the forward joystick setting (between -1 and 1) and the
     * turn joystick setting (between -1 and 1)
     * 
     * For tank drive, we have a few options
     * <ul>
     * <li>Drive forward: both motors on as much as the joystick is pushed forward</li>
     * <li>Drive backward: both motors on in reverse as much as the joystick is pushed backward</li>
     * <li>Turn right: left motors reversed, right motors forward as much as the joystick is pushed right</li>
     * <li>Turn left: left motors forward, right motors reversed as much as the joystick is pushed left</li>
     * <li>Drive forward and turn: Motors are blended based on the intensity of the joysticks</li>
     * </ul>
     */
    public void tankDrive(double forward, double turn) {
        // If we are turning and moving forward at the same time, reduce how much we turn
        // If we are going full forward, this will be
        // 1.0 - (1.0/2.0) or 0.5
        // i.e. only steer half as much
        //
        // If we are not going forward at all, this will be 
        // 1.0 - 0.0 / 2.0 or 1.0
        // i.e. steer as much as possible
        double maxSteer = 1.0 - Math.abs(forward) / 2.0;	// Reduce steering by up to 50%
        
        // Based on what we calculated above, reduce our "steering" rate
        double steer = maxSteer * turn;
        
        // Set the motors based on how much we are going forward/backward and how
        // much we are steering left or right
		leftFrontMotor.set(ControlMode.PercentOutput, forward + steer);
        rightFrontMotor.set(ControlMode.PercentOutput, forward - steer);
        
    }

    /**
     * Stop the motors
     */
    public void stop() {
        leftFrontMotor.set(ControlMode.PercentOutput, 0);
        rightFrontMotor.set(ControlMode.PercentOutput, 0);
    }
    
}