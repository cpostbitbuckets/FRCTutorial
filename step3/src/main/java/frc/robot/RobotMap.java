package frc.robot;

/**
 * A Mapping of motor indexes to robots
 */
public class RobotMap {
    
    /* DRIVE SUBSYSTEM */
    public static final int LEFT_DRIVE_MOTOR_FRONT_ID  = 11;
    public static final int LEFT_DRIVE_MOTOR_REAR_ID   = 12;
    public static final int RIGHT_DRIVE_MOTOR_FRONT_ID = 13;
    public static final int RIGHT_DRIVE_MOTOR_REAR_ID  = 14;

    /* DRIVE SUBSYSTEM */
    // DriveSubsystem Motor Directions
    // Assuming a single stage gearbox and motors mounted on
    // interior with axle pointing outward. Using right hand
    // rule for positive motor command yields the following:
    //		Left			Right
    //		INVERTED		NOT-INVERTED
    public static final boolean LEFT_DRIVE_MOTOR_INVERSION_FLAG = true;
    public static final boolean RIGHT_DRIVE_MOTOR_INVERSION_FLAG = false;

}
