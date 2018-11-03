# Step 2

It's time to do some actual Robot'ing with our robot code.

## Add frc support to gradle

Add the GradleRIO plugin to build.gradle

    plugins {
        ...
        id "edu.wpi.first.GradleRIO" version "2019.0.0-alpha-3"
    }

    // define the robot class for GradleRIO
    def ROBOT_CLASS = "org.usfirst.frc.team4183.robot"

    // Define my targets (RoboRIO) and artifacts (deployable files)
    // This is added by GradleRIO's backing project EmbeddedTools.
    deploy {
        targets {
            target("roborio", edu.wpi.first.gradlerio.frc.RoboRIO) {
                // Team number is loaded either from the .wpilib/wpilib_preferences.json
                // or from command line. If not found an exception will be thrown.
                // You can use getTeamOrDefault(team) instead of getTeamNumber if you
                // want to store a team number in this file.
                team = getTeamNumber()
            }
        }
        artifacts {
            artifact('frcJava', edu.wpi.first.gradlerio.frc.FRCJavaArtifact) {
                targets << "roborio"
                // Debug can be overridden by command line, for use with VSCode
                debug = getDebugOrDefault(false)
            }
        }
    }

    dependencies {
        compile wpilib()
        compile ctre()
        compile navx()
    }

    // Setting up my Jar File. In this case, adding all libraries into the main jar ('fat jar')
    // in order to make them all available at runtime. Also adding the manifest so WPILib
    // knows where to look for our Robot Class.
    jar {
        from configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
        manifest edu.wpi.first.gradlerio.GradleRIOPlugin.javaManifest(ROBOT_CLASS)
    }

## Add wpilib_preferences.json

Create a new .wpilib/ directory in your project and add wpilib_preferences.json to it

    {
        "currentLanguage": "java",
        "teamNumber": 4183
    }

This will tell the wpi library what your team number and language is.

## Test your robot to make sure it still runs

    gradle run

    > Configure project :
    NOTE: You are using an ALPHA version of GradleRIO, designed for the 2019 Season!
    This release uses the 2018 Core Libraries, however all tooling (GradleRIO + IDE support) is incubating for 2019
    If you encounter any issues and/or bugs, please report them to https://github.com/wpilibsuite/GradleRIO

    > Task :run
    Hello, Robot

    BUILD SUCCESSFUL in 0s
    2 actionable tasks: 2 executed