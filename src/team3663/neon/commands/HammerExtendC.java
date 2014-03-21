package team3663.neon.commands;

public class HammerExtendC extends CommandBase {
    
    public HammerExtendC() {
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
