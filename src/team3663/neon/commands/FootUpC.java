package team3663.neon.commands;

public class FootUpC extends CommandBase {
    
    public FootUpC() {
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
