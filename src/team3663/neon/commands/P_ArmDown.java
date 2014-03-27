package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_ArmDown extends CommandBase {
    
    double endTime;

    public P_ArmDown() {
    }

    protected void initialize() {
        SmartDashboard.putString("P_ArmDown", "initialize");        
        armSS.armDown();
        endTime = Timer.getFPGATimestamp() + .5;
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
        SmartDashboard.putString("P_ArmDown", "end");
    }

    protected void interrupted() {
        SmartDashboard.putString("P_ArmDown", "interrupted");
    }
}
