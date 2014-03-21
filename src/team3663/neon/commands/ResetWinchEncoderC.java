package team3663.neon.commands;

public class ResetWinchEncoderC extends CommandBase {
    
    public ResetWinchEncoderC() {
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
