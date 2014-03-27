package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_LatchClose extends CommandBase {
    double endTime;
    public P_LatchClose() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_LatchClose", "initialize");        
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
        SmartDashboard.putString("P_LatchClose", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_LatchClose", "interrupted");
    }
}
