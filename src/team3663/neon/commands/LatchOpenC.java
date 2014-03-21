package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LatchOpenC extends CommandBase {
    
    double endTime;
    
    public LatchOpenC() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("LatchOpenC", "initialize");        
        System.out.println("LatchOpenC.initialize");
        winchAndLatchSS.latchOpen();
        endTime = Timer.getFPGATimestamp()+1;
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~~~DO NOT FIRE~~~");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() > endTime)
        {
            return true;
        }
        if(catapultLimitSwitchSS.catapultIsDown())
        {
            return false;
        }
        return true;
    }

    protected void end() {
        SmartDashboard.putString("LatchOpenC", "end");        
        System.out.println("LatchOpenC.end");
    }

    protected void interrupted() {
        SmartDashboard.putString("LatchOpenC", "interrupted");        
        System.out.println("LatchOpenC.interrupted");
    }
}
