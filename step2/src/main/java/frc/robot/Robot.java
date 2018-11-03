package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        super.robotInit();
        System.out.println("Hello Robot Init!");
    }

    public static void main(String[] args) {
        System.out.println("Hello, Robot");
    }
}