package team3663.neon.commands;

import team3663.neon.Robot3663;
import team3663.neon.RobotMap;

public class C_DriveBasedOnEncoders extends CommandBase {
    
    double leftEncoderTicksGoal;
    double leftSpeed, leftDirection;
    boolean leftMovingForward;
    
    double rightEncoderTicksGoal;
    double rightSpeed, rightDirection;
    boolean rightMovingForward;
    
    public C_DriveBasedOnEncoders(double pLeftEncoderTicksGoal, double pRightEncoderTicksGoal) {
        requires(driveTrainSS);
        leftEncoderTicksGoal = pLeftEncoderTicksGoal;
        rightEncoderTicksGoal = pRightEncoderTicksGoal;
    }

    protected void initialize() {
        
        Robot3663.updateCommandStatus("C_DriveBasedOnEncoders", "Initialize");
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

    protected void execute() {
        RobotMap.driveTrainBackLeftSpeedController.set(-leftSpeed);
        RobotMap.driveTrainFrontLeftSpeedController.set(-leftSpeed);
        RobotMap.driveTrainBackRightSpeedController.set(-rightSpeed);
        RobotMap.driveTrainFrontRightSpeedController.set(-rightSpeed);
    }

    protected boolean isFinished() {
        
        leftSpeed = findNewSpeed(leftEncoderTicksGoal, driveTrainSS.GetLeftEncoder(), leftSpeed, leftDirection, leftMovingForward);
        rightSpeed = findNewSpeed(rightEncoderTicksGoal, driveTrainSS.GetRightEncoder(), rightSpeed, rightDirection, rightMovingForward);

        if ((leftSpeed == 0) && (rightSpeed == 0))
            return true;
        else
            return false;
    }
    
    protected double findNewSpeed(double ticksGoal, double currentTicks, double currentSpeed, double direction, boolean movingForward)
    {
        double newSpeed = currentSpeed;
        
        if (movingForward){
            if (currentTicks > ticksGoal){
                return 0;
            }
        } else {
            if (currentTicks < ticksGoal){
                return 0;
            }
        }
        
        double lCurrentTicks = currentTicks;
        if (lCurrentTicks < 0)
            lCurrentTicks = -lCurrentTicks;
        
        if (lCurrentTicks > 4500)
            newSpeed = 1 * direction;
        else if (lCurrentTicks < 500)
            newSpeed = .25 * direction;
        else if (lCurrentTicks < 1500)
            newSpeed = .4 * direction;
        else if (lCurrentTicks < 3000)
            newSpeed = .6 * direction;
        else if (lCurrentTicks < 4500)
            newSpeed = .75 * direction;
        
        double ticksToGo = ticksGoal - currentTicks;
        if (ticksToGo < 0)
            ticksToGo = -ticksToGo;
        
        if (ticksToGo < 500)
            return 0;
        else if (ticksToGo < 1500)
            newSpeed = .1 * direction;
        else if (ticksToGo < 3000)
            newSpeed = .25 * direction;
        else if (ticksToGo < 4500)
            newSpeed = .5 * direction;

 /*
        if (movingForward){
            if (currentSpeed < newSpeed){
                return currentSpeed;
            }
        } else {
            if (currentSpeed > newSpeed){
                return currentSpeed;
            }
        }
  */      
        return newSpeed;
    }

    protected void end() {
        Robot3663.updateCommandStatus("C_DriveBasedOnEncoders", "End");
        RobotMap.driveTrainBackLeftSpeedController.set(0);
        RobotMap.driveTrainFrontLeftSpeedController.set(0);
        RobotMap.driveTrainBackRightSpeedController.set(0);
        RobotMap.driveTrainFrontRightSpeedController.set(0);
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("C_DriveBasedOnEncoders", "Interrupted");
        end();
    }
}
