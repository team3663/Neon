package team3663.neon.commands;

public class P_WinchTighten extends CommandBase {
    
    public P_WinchTighten() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        winchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        end();
    }
}
