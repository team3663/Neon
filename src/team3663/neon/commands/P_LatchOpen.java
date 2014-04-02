package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_LatchOpen extends CommandBase {
    
    double endTime;
    
    public P_LatchOpen() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_LatchOpen", "initialize");        
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
        Robot3663.updateCommandStatus("P_LatchOpen", "end");        
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_LatchOpen", "interrupted");        
    }
}
