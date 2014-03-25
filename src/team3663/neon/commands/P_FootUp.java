package team3663.neon.commands;

public class P_FootUp extends CommandBase {
    
    public P_FootUp() {
        //requires(footSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        footSS.footUp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
