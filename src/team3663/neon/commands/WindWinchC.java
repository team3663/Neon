package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;

public class WindWinchC extends CommandBase {
    
    double targetTicks;
    boolean tightening;
    double speed;
    double direction;
    //double tighteningScale;
    //double looseningScale;
    
    public WindWinchC(double pTargetTicks) {
        requires(shooterWinchAndLatchSS);
        targetTicks = pTargetTicks;
    }

    //encoder tightens using negative speed
    //encoder counts deacrese when tightened
    protected void initialize() {
       /* if(targetTicks == 200)
        {
            oi.fullButtonPressedOnce(false);
            oi.mediumButtonPressedOnce(false);
            oi.weakButtonPressedOnce(true);
        }
        else if(targetTicks == 100)
        {
            oi.fullButtonPressedOnce(false);
            oi.mediumButtonPressedOnce(true);
            oi.weakButtonPressedOnce(false);
        }
        else if(targetTicks == 0)
        {
            oi.fullButtonPressedOnce(true);
            oi.mediumButtonPressedOnce(false);
            oi.weakButtonPressedOnce(false);
        }*/
        System.out.println("WindWinch.initialize" + targetTicks);
        tightening = shooterWinchAndLatchSS.getWinchEncoder() > targetTicks;
        if (tightening){
            direction = speed = -1;
        }
        else{
            direction = speed = 1;
        }
        /*if(targetTicks > 100)
        {
            looseningScale = tighteningScale = 1;
        }
        else
        {
            looseningScale = tighteningScale = targetTicks/100;
        }*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterWinchAndLatchSS.setWinchSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentTicks = shooterWinchAndLatchSS.getWinchEncoder();
        
        //stop if goal passed
        if (tightening){
            if (currentTicks < targetTicks){
                return true;
            }
        } else {
            if (currentTicks > targetTicks){
                return true;
            }
        }

        //double ticksToGo = targetTicks - currentTicks;
        //if (ticksToGo < 0)
          //  ticksToGo = -ticksToGo;
        
        //if(tightening)
        /*{
            if (ticksToGo < 1)
                return true;
            else if (ticksToGo < 15*tighteningScale)
                speed = .25 * direction;
            else if (ticksToGo < 30*tighteningScale)
                speed = .5 * direction;
            else if (ticksToGo < 45*tighteningScale)
                speed = .75 * direction;
        }
        /*else
        {
            if (ticksToGo < 15/looseningScale)
                return true;
            else if (ticksToGo < 30/looseningScale)
                speed = .25 * direction;
            else if (ticksToGo < 60/looseningScale)
                speed = .5 * direction;
            else if (ticksToGo < 120/looseningScale)
                speed = .75 * direction;
        }*/
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~~~~READY TO FIRE~~~~");
        shooterWinchAndLatchSS.readyToShoot = true;
        shooterWinchAndLatchSS.setWinchSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
