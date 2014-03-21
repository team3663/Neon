package team3663.neon.commands;

public class FootDownC extends CommandBase {
    
    public FootDownC() {
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
