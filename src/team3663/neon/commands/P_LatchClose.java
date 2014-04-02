package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_LatchClose extends CommandBase {
    double endTime;
    public P_LatchClose() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_LatchClose", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        winchAndLatchSS.latchClose();
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_LatchClose", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_LatchClose", "interrupted");
    }
}
