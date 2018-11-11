package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    private final Robot robot;

    private final WPI_TalonSRX leftFrontMotor;
	private final WPI_TalonSRX leftRearMotor;

	private final WPI_TalonSRX rightFrontMotor;
	private final WPI_TalonSRX rightRearMotor;

    /**
     * Constructor for DriveSubsystem. Pass in the robot instance so we can refer to it later.
     */
    public DriveSubsystem(Robot robot) {
        this.robot = robot;

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
     * @return the robot
     */
    public Robot getRobot() {
        return robot;
    }

}