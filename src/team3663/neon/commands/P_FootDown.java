package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_FootDown extends CommandBase {
    double endTime;
    public P_FootDown() {
       // requires(footSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_FootDown", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        footSS.footDown();
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_FootDown", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_FootDown", "interrupted");
    }
}
