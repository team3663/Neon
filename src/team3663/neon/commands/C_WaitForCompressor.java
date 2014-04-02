package team3663.neon.commands;

public class C_WaitForCompressor extends CommandBase {
    
    public C_WaitForCompressor() {
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(compressorSS.airTanksAreFull())
        {
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
