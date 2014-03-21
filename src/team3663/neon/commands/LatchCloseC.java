package team3663.neon.commands;

public class LatchCloseC extends CommandBase {
    
    public LatchCloseC() {
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
