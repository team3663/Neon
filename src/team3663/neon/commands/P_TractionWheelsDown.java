package team3663.neon.commands;

public class P_TractionWheelsDown extends CommandBase {
    
    public P_TractionWheelsDown() {
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
