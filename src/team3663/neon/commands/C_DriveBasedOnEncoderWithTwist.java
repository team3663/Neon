/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class C_DriveBasedOnEncoderWithTwist extends CommandBase {
    //twist stuff
    double amountOfTwist = 0;
    double rightEncoderDistance;
    double leftEncoderDistance;
    double rightEncoderStartDistance;
    double leftEncoderStartDistance;
    double distance;
    double finalDistanceR;
    double finalDistanceL;
    
    //timer stuff
    final double INITIALSPEED = 0;
    double startDistanceR;
    double acceleration;
    double initialAcceleration;
    double lastTime;
    double currentSpeed;
    double peakSpeed;
    
    public C_DriveBasedOnEncoderWithTwist(double pPeakSpeed, double pDistance, double pAcceleration) {
        peakSpeed = pPeakSpeed;
        distance = pDistance;
        acceleration = initialAcceleration = pAcceleration;        
        requires(driveTrainSS); 
    }

    protected void initialize() {
        
        //timer stuff
        currentSpeed = INITIALSPEED;
        lastTime = Timer.getFPGATimestamp();
        
        //twist stuff
        startDistanceR = driveTrainSS.GetRightEncoder();
        finalDistanceR = startDistanceR + distance;
        /*finalDistanceL = driveTrainSS.GetLeftEncoder() + distance;
        rightEncoderStartDistance = driveTrainSS.GetRightEncoder();
        leftEncoderStartDistance = driveTrainSS.GetLeftEncoder();*/
    }

    protected void execute() {
        
        //twist stuff
        /*rightEncoderDistance = (driveTrainSS.GetRightEncoder() - rightEncoderStartDistance) / 100;
        leftEncoderDistance = (driveTrainSS.GetLeftEncoder() - leftEncoderStartDistance) / 100;
        amountOfTwist = rightEncoderDistance - leftEncoderDistance;*/ 
        
        //timer stuff
        if (acceleration != 0)
        {
            double currentTime = Timer.getFPGATimestamp();
            double deltaTime = currentTime - lastTime;
            lastTime = currentTime;
             
            currentSpeed = currentSpeed + acceleration * deltaTime;
            if(currentSpeed >= peakSpeed)
            {
                System.out.println("" + driveTrainSS.GetRightEncoder());
                finalDistanceR = finalDistanceR - (driveTrainSS.GetRightEncoder() - startDistanceR);
                currentSpeed = peakSpeed;
                System.out.println("" + finalDistanceR);
                acceleration = 0;
            }
        }
        
        driveTrainSS.drive3663(0, currentSpeed, amountOfTwist);
    }

    protected boolean isFinished() {
        //twist stuff
        /*rightEncoderStartDistance = driveTrainSS.GetRightEncoder();
        leftEncoderStartDistance = driveTrainSS.GetLeftEncoder();*/
        
        //timer stuff
        double currentEncoderR = driveTrainSS.GetRightEncoder();
        if((currentEncoderR >= finalDistanceR/2)&&(acceleration > 0))
        {            
            System.out.println("hit half way mark" + currentEncoderR);
            acceleration = -initialAcceleration;
        }
        if((driveTrainSS.GetRightEncoder() >= finalDistanceR)/*&&(driveTrainSS.GetLeftEncoder() >= finalDistanceL)*/)
        {
            System.out.println("the signs were flopped" + currentEncoderR);
            acceleration = -initialAcceleration;
        }
        if((acceleration < 0)&&(currentSpeed <= INITIALSPEED))
        {
            return true;
        }
        return false;
        
    }

    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
        end();
    }
}
