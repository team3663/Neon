package team3663.neon.commands;

public class TractionWheelsUpC extends CommandBase {
    
    public TractionWheelsUpC() {
        requires(driveTrainSS);
    }

    protected void initialize() {
        driveTrainSS.TractionWheelsUp();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
