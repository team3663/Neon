package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_ArmUp extends CommandBase {
    
    double endTime;
    public P_ArmUp() {
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_ArmUp", "initialize");        
        armSS.armUp();
        endTime = Timer.getFPGATimestamp() + 1;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() > endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        Robot3663.updateCommandStatus("P_ArmUp", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_ArmUp", "interrupted");
    }
}
