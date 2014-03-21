package team3663.neon.commands;

public class TractionWheelsDownC extends CommandBase {
    
    public TractionWheelsDownC() {
        requires(driveTrainSS);
    }

    protected void initialize() {
        driveTrainSS.TractionWheelsDown();
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
