package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_TractionWheelsDown extends CommandBase {
    double endTime;
    public P_TractionWheelsDown() {
       // requires(driveTrainSS);
    }

    protected void initialize() {
        SmartDashboard.putString("P_TractionWheelsDown", "initialize");        
        endTime = Timer.getFPGATimestamp() + 0.5;
        driveTrainSS.TractionWheelsDown();
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
        SmartDashboard.putString("P_TractionWheelsDown", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_TractionWheelsDown", "interrupted");
    }
}
