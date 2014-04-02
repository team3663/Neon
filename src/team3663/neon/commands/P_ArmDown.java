package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_ArmDown extends CommandBase {
    
    double endTime;

    public P_ArmDown() {
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("P_ArmDown", "initialize");        
        armSS.armDown();
        endTime = Timer.getFPGATimestamp() + .5;
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
        Robot3663.updateCommandStatus("P_ArmDown", "end");
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("P_ArmDown", "interrupted");
    }
}
