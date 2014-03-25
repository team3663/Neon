package team3663.neon.commands;

public class P_TractionWheelsUp extends CommandBase {
    
    public P_TractionWheelsUp() {
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
