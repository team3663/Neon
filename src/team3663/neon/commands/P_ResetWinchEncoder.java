package team3663.neon.commands;

public class P_ResetWinchEncoder extends CommandBase {
    
    public P_ResetWinchEncoder() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        winchAndLatchSS.winchEncoderReset();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
