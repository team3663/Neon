package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_FootUp extends CommandBase {
    double endTime;
    public P_FootUp() {
        //requires(footSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_FootUp", "initialize");        
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
        SmartDashboard.putString("P_FootUp", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_FootUp", "interrupted");
    }
}
