package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_TractionWheelsUp extends CommandBase {
    double endTime;
    public P_TractionWheelsUp() {
       // requires(driveTrainSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_TractionWheelsUp", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
        driveTrainSS.TractionWheelsUp();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_TractionWheelsUp", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_TractionWheelsUp", "interrupted");
    }
}
