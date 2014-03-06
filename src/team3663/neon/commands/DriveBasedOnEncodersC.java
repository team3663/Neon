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
    
    double rightEncoderTicksGoal;
    double rightSpeed, rightDirection;
    boolean rightMovingForward;
    
    public DriveBasedOnEncodersC(double pLeftEncoderTicksGoal, double pRightEncoderTicksGoal) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrainSS);
        leftEncoderTicksGoal = pLeftEncoderTicksGoal;
        rightEncoderTicksGoal = pRightEncoderTicksGoal;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double rightAdjust, leftAdjust;
        
        driveTrainSS.ResetDriveEncoders();
        if (leftEncoderTicksGoal > 0)
        {
            leftSpeed = leftDirection = 1;
            leftMovingForward = true;
            leftAdjust = leftEncoderTicksGoal;
        }
        else
        {
            leftSpeed = leftDirection = -1;
            leftMovingForward = false;
            leftAdjust = -leftEncoderTicksGoal;
        }

        if (rightEncoderTicksGoal > 0)
        {
            rightSpeed = rightDirection = 1;
            rightMovingForward = true;
            rightAdjust = rightEncoderTicksGoal;
        }
        else
        {
            rightSpeed = rightDirection = -1;
            rightMovingForward = false;
            rightAdjust = -rightEncoderTicksGoal;
        }
        
        if (rightAdjust > leftAdjust)
        {
            if (rightAdjust == 0)
                leftSpeed *= leftAdjust/rightAdjust;            
        }
        else if (leftAdjust > rightAdjust)
        {
            if (leftAdjust == 0)
                rightSpeed *= rightAdjust/leftAdjust;            
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotMap.driveTrainBackLeftSpeedController.set(leftSpeed);
        RobotMap.driveTrainFrontLeftSpeedController.set(leftSpeed);
        RobotMap.driveTrainBackRightSpeedController.set(rightSpeed);
        RobotMap.driveTrainFrontRightSpeedController.set(rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentLeftTicks = driveTrainSS.GetLeftEncoder();
        
        //stop if goal passed
        if (leftMovingForward){
            if (currentLeftTicks > leftEncoderTicksGoal){
                leftSpeed = 0;
            }
        } else {
            if (currentLeftTicks < leftEncoderTicksGoal){
                leftSpeed = 0;
            }
        }

        double ticksToGo = leftEncoderTicksGoal - currentLeftTicks;
        if (ticksToGo < 0)
            ticksToGo = -ticksToGo;
        
        if (ticksToGo < 5)
            leftSpeed = 0;
        else if (ticksToGo < 15)
            leftSpeed = .25 * leftDirection;
        else if (ticksToGo < 30)
            leftSpeed = .5 * leftDirection;
        else if (ticksToGo < 45)
            leftSpeed = .75 * leftDirection;

        double currentRightTicks = driveTrainSS.GetRightEncoder();
        
        //stop if goal passed
        if (rightMovingForward){
            if (currentRightTicks > rightEncoderTicksGoal){
                rightSpeed = 0;
            }
        } else {
            if (currentRightTicks < rightEncoderTicksGoal){
                rightSpeed = 0;
            }
        }

        ticksToGo = rightEncoderTicksGoal - currentRightTicks;
        if (ticksToGo < 0)
            ticksToGo = -ticksToGo;
        
        if (ticksToGo < 5)
            rightSpeed = 0;
        else if (ticksToGo < 15)
            rightSpeed = .25 * rightDirection;
        else if (ticksToGo < 30)
            rightSpeed = .5 * rightDirection;
        else if (ticksToGo < 45)
            rightSpeed = .75 * rightDirection;

        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotMap.driveTrainBackLeftSpeedController.set(0);
        RobotMap.driveTrainFrontLeftSpeedController.set(0);
        RobotMap.driveTrainBackRightSpeedController.set(0);
        RobotMap.driveTrainFrontRightSpeedController.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
