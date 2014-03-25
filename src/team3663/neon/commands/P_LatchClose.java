package team3663.neon.commands;

public class P_LatchClose extends CommandBase {
    
    public P_LatchClose() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        winchAndLatchSS.latchClose();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
