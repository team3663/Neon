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
    double lastEncoderSpeed;
    double loopCounter;
    final double INITIALSPEED = 0.15;
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
        loopCounter = 0;
        currentSpeed = INITIALSPEED;
        lastTime = Timer.getFPGATimestamp();
        
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
        System.out.println("" + ((int)(encoderSpeed*1000))/1000.0  + ", "  + ((int)(deltaEncoderSpeed*1000))/1000.0 +  ", " + ((int)(currentSpeed*1000))/1000.0 );
        if (acceleration != 0)
        {
            currentSpeed = currentSpeed + (acceleration * deltaTime);
            //System.out.println("" + currentSpeed);
            if(currentSpeed >= peakSpeed)
            {
                System.out.println("(" + loopCounter + ") " + "where reached full speed " + currentEncoderTicksR);
                finalDistanceR = finalDistanceR - (currentEncoderTicksR - startDistanceR);
                currentSpeed = peakSpeed;
                System.out.println("(" + loopCounter + ") " + "the subtracted value " + finalDistanceR);
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
        if((currentEncoderR >= (startDistanceR + finalDistanceR/2))&&(acceleration > 0))
        {            
            System.out.println("(" + loopCounter + ") " + "hit half way mark" + currentEncoderR);
            acceleration = -initialAcceleration;
        }
        if((acceleration >= 0) && (currentEncoderR >= finalDistanceR)/*&&(driveTrainSS.GetLeftEncoder() >= finalDistanceL)*/)
        {
            System.out.println("(" + loopCounter + ") " + "decelerating" + currentEncoderR);
            acceleration = -initialAcceleration;
        }
        if((acceleration < 0)&&(currentSpeed <= INITIALSPEED))
        {
            System.out.println("(" + loopCounter + ") " + "ended at" + driveTrainSS.GetRightEncoder());
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
