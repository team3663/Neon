package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_WinchTighten extends CommandBase {
    
    public P_WinchTighten() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_WinchTighten", "initialize");        
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        winchAndLatchSS.setWinchSpeed(0);
        SmartDashboard.putString("P_WinchTighten", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_WinchTighten", "interrupted");
        end();
    }
}
