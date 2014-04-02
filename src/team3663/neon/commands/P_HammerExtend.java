package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_HammerExtend extends CommandBase {
    
    double endTime;
    public P_HammerExtend() {
        requires(hammerSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_HammerExtend", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        hammerSS.hammerExtend();
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_HammerExtend", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_HammerExtend", "interrupted");
    }
}
