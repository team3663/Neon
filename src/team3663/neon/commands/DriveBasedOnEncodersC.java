/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import team3663.neon.RobotMap;

/**
 *
 * @author briking
 */
public class DriveBasedOnEncodersC extends CommandBase {
    
    double leftEncoderTicksGoal;
    double leftSpeed, leftDirection;
    boolean leftMovingForward;
    
    public DriveBasedOnEncodersC(double pLeftEncoderTicksGoal) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrainSS);
        leftEncoderTicksGoal = pLeftEncoderTicksGoal;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrainSS.ResetDriveEncoders();
        if (leftEncoderTicksGoal > 0)
        {
            leftSpeed = leftDirection = 1;
            leftMovingForward = true;
        }
        else
        {
            leftSpeed = leftDirection = -1;
            leftMovingForward = false;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotMap.driveTrainBackLeftSpeedController.set(leftSpeed);
        RobotMap.driveTrainFrontLeftSpeedController.set(leftSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentLeftTicks = driveTrainSS.GetLeftEncoder();
        
        //stop if goal passed
        if (leftMovingForward){
            if (currentLeftTicks > leftEncoderTicksGoal){
                return true;
            }
        } else {
            if (currentLeftTicks < leftEncoderTicksGoal){
                return true;
            }
        }

        double ticksToGo = leftEncoderTicksGoal - currentLeftTicks;
        if (ticksToGo < 0)
            ticksToGo = -ticksToGo;
        
        if (ticksToGo < 5)
            return true;
        else if (ticksToGo < 15)
            leftSpeed = .25 * leftDirection;
        else if (ticksToGo < 30)
            leftSpeed = .5 * leftDirection;
        else if (ticksToGo < 45)
            leftSpeed = .75 * leftDirection;

        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotMap.driveTrainBackLeftSpeedController.set(0);
        RobotMap.driveTrainFrontLeftSpeedController.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
