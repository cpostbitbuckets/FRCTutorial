# FRCTutorial
Tutorial for creating a new FRC robot from scratch.

## Prerequisites

* Install Visual Studio Code
* Install java extensions and wpi lib extensions

## Goals

1. create the new robot as "Timed" - the "Iterative" robot is deprecated. We may still use other custom threads for some things but this should improve timing that does not depend on operator interfaces
2. Use only the WPI_TalonSRX class for motor control - this allows full access to all of the CTRE Phoenix functions
3. Create the project in VS Code
4. Use a static RobotMap class with the ID constants - place the  RobotMap in the frc.robot package
5. Keep the DriveSubsystem class in its own package (e.g., frc.robot.driveSubsystem)
6. consider adding a SendableChooser to the DriveSubsystem that allows enumerated selection of different drive styles offered by the DifferentialDrive class
7. Initialize ALL configurable motor controller constants - consider creating a utility function that accepts a structured type
8. Bonus - consider using the dependency injection pattern to construct and initialize the DriveSubsystem with the motor IDs, controller constants, and the joystick or joystick axes dependencies (i.e., see if you can avoid the RobotMap import and the naming dependencies and identify what the pros and cons of doing such is)

## How To
This tutorial is broken into subfolders with various steps for creating a new robot codebase from scratch. Start with step1.

* [Step 1](step1/)
* [Step 2](step2/)
* [Step 3](step3/)

## Mac Simulator Notes

**Note** This is not fully documented yet. More notes will appear here as I flesh out the simulator.

Copy the pathfinder libs

    cp ../../Pathfinder/Pathfinder-Java/build/libs/pathfinderjava/shared/any64/* build/native_libs

