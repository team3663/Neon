package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_HammerExtend extends CommandBase {
    
    double endTime;
    public P_HammerExtend() {
        requires(hammerSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_HammerExtend", "initialize");        
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
        SmartDashboard.putString("P_HammerExtend", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_HammerExtend", "interrupted");
    }
}
