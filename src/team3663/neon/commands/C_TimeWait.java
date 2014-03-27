package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_TimeWait extends CommandBase {
    
    double endTime;
    double seconds;
    
    public C_TimeWait(double timeToWait) {
        seconds = timeToWait;
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + seconds;
        SmartDashboard.putString("C_TimeWait", "initialize " + seconds);        
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
        SmartDashboard.putString("C_TimeWait", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("C_TimeWait", "interrupted");        
    }
}
