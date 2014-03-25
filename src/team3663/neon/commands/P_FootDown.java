package team3663.neon.commands;

public class P_FootDown extends CommandBase {
    
    public P_FootDown() {
       // requires(footSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        footSS.footDown();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
