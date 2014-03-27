package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_TractionWheelsUp extends CommandBase {
    double endTime;
    public P_TractionWheelsUp() {
        requires(driveTrainSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_TractionWheelsUp", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
        driveTrainSS.TractionWheelsUp();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("P_TractionWheelsUp", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_TractionWheelsUp", "interrupted");
    }
}
