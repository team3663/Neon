package team3663.neon.commands;

public class P_ChangeValueForDriver extends CommandBase {
    
    public P_ChangeValueForDriver() {
        // eg. requires(chassis);
    }

    protected void initialize() {
        driveTrainSS.changeDriveY();
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
