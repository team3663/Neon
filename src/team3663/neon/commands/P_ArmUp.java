package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_ArmUp extends CommandBase {
    
    double endTime;
    public P_ArmUp() {
    }

    protected void initialize() {
        SmartDashboard.putString("P_ArmUp", "initialize");        
        armSS.armUp();
        endTime = Timer.getFPGATimestamp() + 1;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() > endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("P_ArmUp", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_ArmUp", "interrupted");
    }
}
