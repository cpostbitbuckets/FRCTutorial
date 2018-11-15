# Step 4

In step 3 we created a Drive Subsystem with 4 motors. The subsystem only idles. We need to add a joystick to steer our robot around. We are going to setup a joystick to do a tank drive style. This will mean one joystick on the controller will move forward and backward, and another will turn the robot left and right.

## DriveSubsystem.tankDrive()
The first thing we need is some logic to tell the robot to move around based on joystick inputs. Create a new method in DriveSubsystem called tankDrive()

