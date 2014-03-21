package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WinchTightenC extends CommandBase {
    
    public WinchTightenC() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("WinchTightenC", "initialize");        
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        winchAndLatchSS.setWinchSpeed(0);
        SmartDashboard.putString("WinchTightenC", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("WinchTightenC", "interrupted");
        end();
    }
}
