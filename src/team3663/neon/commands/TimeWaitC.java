package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TimeWaitC extends CommandBase {
    
    double endTime;
    double seconds;
    
    public TimeWaitC(double timeToWait) {
        seconds = timeToWait;
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + seconds;
        SmartDashboard.putString("TimeWaitC", "initialize " + seconds);        
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
        SmartDashboard.putString("TimeWaitC", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("TimeWaitC", "interrupted");        
    }
}
