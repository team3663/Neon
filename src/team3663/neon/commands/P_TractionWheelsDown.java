package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_TractionWheelsDown extends CommandBase {
    double endTime;
    boolean doWaitTime;
    
    public P_TractionWheelsDown(boolean pDoWaitTime) {
        doWaitTime = pDoWaitTime;
       // requires(driveTrainSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_TractionWheelsDown", "initialize");        
        endTime = Timer.getFPGATimestamp() + 0.1;
        driveTrainSS.TractionWheelsDown();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(!doWaitTime)
        {
            return true;
        }
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_TractionWheelsDown", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_TractionWheelsDown", "interrupted");
    }
}
