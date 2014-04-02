package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class C_TimeWait extends CommandBase {
    
    double endTime;
    double seconds;
    
    public C_TimeWait(double timeToWait) {
        seconds = timeToWait;
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + seconds;
        Robot3663.updateCommandStatus("C_TimeWait", "initialize " + seconds);        
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
        Robot3663.updateCommandStatus("C_TimeWait", "end");        
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("C_TimeWait", "interrupted");        
    }
}
