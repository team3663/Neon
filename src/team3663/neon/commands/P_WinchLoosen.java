package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_WinchLoosen extends CommandBase {
    
    public P_WinchLoosen() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("WinchLoosenC", "initialize");        
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        winchAndLatchSS.setWinchSpeed(0);
        SmartDashboard.putString("WinchLoosenC", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("WinchLoosenC", "interrupted");        
        end();
    }
}