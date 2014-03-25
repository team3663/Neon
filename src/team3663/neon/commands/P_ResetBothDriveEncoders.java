
package team3663.neon.commands;

public class P_ResetBothDriveEncoders extends CommandBase {
    
    public P_ResetBothDriveEncoders() {
    }

    protected void initialize() {
        driveTrainSS.ResetDriveEncoders();
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
