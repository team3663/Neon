/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author curtis
 */
public class MotorTestC extends CommandBase {
    int motorNumber;
    double seconds;
    double endTime;
    double speed;
    
    public MotorTestC(int pRobotNumber, double pEndTime, double pSpeed) {
        motorNumber = pRobotNumber;
        seconds = pEndTime;
        endTime = seconds + Timer.getFPGATimestamp();
        speed = pSpeed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(motorNumber == 1)
        {
            driveTrainSS.TestMotors(1, speed);
        }
        if(motorNumber == 2)
        {
            driveTrainSS.TestMotors(2, speed);
        }
        if(motorNumber == 3)
        {
            driveTrainSS.TestMotors(3, speed);
        }
        if(motorNumber == 4)
        {
            driveTrainSS.TestMotors(4, speed);
        }
        if(motorNumber == 5)
        {
            driveTrainSS.TestMotors(5, speed);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        seconds = Timer.getFPGATimestamp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(seconds >= endTime)
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrainSS.TestMotors(1, 0);
        driveTrainSS.TestMotors(2, 0);
        driveTrainSS.TestMotors(3, 0);
        driveTrainSS.TestMotors(4, 0);
        driveTrainSS.TestMotors(5, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
