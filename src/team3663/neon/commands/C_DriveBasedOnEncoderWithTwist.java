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
    double lastEncoderTicksR;
    double rightEncoderDistance;
    double leftEncoderDistance;
    double rightEncoderStartDistance;
    double leftEncoderStartDistance;
    double distance;
    double finalDistanceR;
    double finalDistanceL;
    
    //timer stuff
    double startOfDecelerationX;
    double startOfDecelerationY;
    double endOfDecelerationX;
    double endOfDecelerationY;
    double lastEncoderSpeed;
    double loopCounter;
    final double INITIALSPEED = 0.15;
    double startDistanceR;
    double acceleration;
    double initialAcceleration;
    double lastTime;
    double currentSpeed;
    double peakSpeed;
    double slope;
    
    public C_DriveBasedOnEncoderWithTwist(double pPeakSpeed, double pDistance, double pAcceleration) {
        peakSpeed = pPeakSpeed;
        distance = pDistance;
        acceleration = initialAcceleration = pAcceleration;        
        requires(driveTrainSS); 
    }

    protected void initialize() {
        
        //timer stuff
        loopCounter = 0;
        currentSpeed = INITIALSPEED;
        lastTime = Timer.getFPGATimestamp();
        lastEncoderTicksR = driveTrainSS.GetRightEncoder();
        
        //twist stuff
        startDistanceR = driveTrainSS.GetRightEncoder();
        finalDistanceR = startDistanceR + distance;
        System.out.println("\n\n");
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
        loopCounter++;
        double currentEncoderTicksR = driveTrainSS.GetRightEncoder();
        double deltaEncoderTicksR = currentEncoderTicksR - lastEncoderTicksR;
        lastEncoderTicksR = currentEncoderTicksR;
   
        double currentTime = Timer.getFPGATimestamp();
        double deltaTime = currentTime - lastTime;
        lastTime = currentTime;
   
        double encoderSpeed = deltaEncoderTicksR / deltaTime;
        double deltaEncoderSpeed = encoderSpeed - lastEncoderSpeed;
        lastEncoderSpeed = encoderSpeed;
        // System.out.println(""  /* deltaEncoderTicksR + ", " + ((int)(deltaTime*1000))/1000.0 + ", " + ((int)(deltaSpeed*1000))/1000.0  + ", " + currentSpeed*/);
        System.out.println("" + loopCounter + ", " + ((int)(encoderSpeed*1000))/1000.0  + ", "  + ((int)(deltaEncoderSpeed*1000))/1000.0 +  ", " + ((int)(currentSpeed*1000))/1000.0/* + ", " + currentEncoderTicksR + ", "+ deltaTime + ", " + encoderSpeed + ", " + deltaEncoderTicksR*/);
        if (acceleration != 0)
        {
            currentSpeed = currentSpeed + (acceleration * deltaTime);
            //System.out.println("" + currentSpeed);
            if(currentSpeed >= peakSpeed)
            {
                System.out.println("(" + loopCounter + ") " + "Peak " + currentEncoderTicksR);
                currentSpeed = peakSpeed;
                acceleration = 0;
            }
        }
        
        driveTrainSS.drive3663(0, currentSpeed, amountOfTwist);
    }

    protected boolean isFinished() {
        double currentEncoderR = driveTrainSS.GetRightEncoder();
        //twist stuff
        /*rightEncoderStartDistance = driveTrainSS.GetRightEncoder();
        leftEncoderStartDistance = driveTrainSS.GetLeftEncoder();*/
        
        //y = mx + b
        if(acceleration >= 0)
        {
            double xDistance = -lastEncoderSpeed / -1.460096;
            double distanceWithDecline = xDistance + lastEncoderTicksR;
            if(distanceWithDecline >= finalDistanceR)
            {
                
                startOfDecelerationX = currentEncoderR;
                startOfDecelerationY = lastEncoderSpeed;
                System.out.println("Decceleration "+ lastEncoderTicksR + ", " + xDistance + ", " + distanceWithDecline + ", " + currentSpeed);
                acceleration = -1;
            }
        }
        if((acceleration < 0)&&(lastEncoderSpeed <= 0))
        {
            
            endOfDecelerationX = currentEncoderR;
            endOfDecelerationY = lastEncoderSpeed;
            slope = (endOfDecelerationY - startOfDecelerationY) / (endOfDecelerationX - startOfDecelerationX);
            System.out.println("" + slope);
            return true;
        }
        /*if((acceleration < 0)&&(currentSpeed <= INITIALSPEED))
        {
            System.out.println("(" + loopCounter + ") " + "ended at" + driveTrainSS.GetRightEncoder());
            return true;
        }*/
        return false;
        
    }

    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
        end();
    }
}
