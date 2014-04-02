package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_FootUp extends CommandBase {
    double endTime;
    public P_FootUp() {
        //requires(footSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_FootUp", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        footSS.footUp();
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_FootUp", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_FootUp", "interrupted");
    }
}
