package team3663.neon.commands;

public class P_HammerExtend extends CommandBase {
    
    public P_HammerExtend() {
        requires(hammerSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        hammerSS.hammerExtend();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
