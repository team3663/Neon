package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WindWinchC extends CommandBase {
    
    double targetTicks;
    boolean tightening;
    double speed;
    double direction;
    int counter;
    double encoder;

    public WindWinchC(double pTargetTicks) {
        requires(winchAndLatchSS);
        targetTicks = pTargetTicks;
    }

    //encoder tightens using negative speed
    //encoder counts deacrese when tightened
    protected void initialize() {
        encoder = winchAndLatchSS.getWinchEncoder();
        counter = 0;
        SmartDashboard.putString("WindWinchC", "initialize "+targetTicks);
        System.out.println("WindWinch.initialize" + targetTicks);
        tightening = winchAndLatchSS.getWinchEncoder() > targetTicks;
        if (tightening){
            direction = speed = -1;
        }
        else{
            direction = speed = 1;
        }
    }

    protected void execute() {
        counter++;
        winchAndLatchSS.setWinchSpeed(speed);
    }

    protected boolean isFinished() {
        double currentTicks = winchAndLatchSS.getWinchEncoder();
        
        //stop if goal passed
        if (tightening){
            if (currentTicks <= targetTicks){
                return true;
            }
        } else {
            if (currentTicks >= targetTicks){
                return true;
            }
        }
        if ((counter >= 50)&&(encoder == winchAndLatchSS.getWinchEncoder()))
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("WindWinchC", "end");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~~~~READY TO FIRE~~~~");
        winchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        SmartDashboard.putString("WindWinchC", "interrupted");
        end();
    }
}
