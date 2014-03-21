 package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LaunchBallC  extends CommandBase 
{
    public boolean isFinished;
    double endTime;
    
    // give the ball time to leave
    final double DURATION = 0.75;
    
    public LaunchBallC()
    {
        requires(winchAndLatchSS);
    }
    
    protected void initialize()
    {
        // This must be done in initialize as the command could be run
        // long after it was created
        endTime = Timer.getFPGATimestamp() + DURATION;
        
        winchAndLatchSS.latchOpen();
        SmartDashboard.putString("LaunchBallC", "initialize");        
    }
    
    protected void execute()
    {
    }
    
    protected boolean isFinished()
    {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }
    
    protected void end()
    {
        SmartDashboard.putString("LaunchBallC", "end");        
    }
    
    protected void interrupted()
    {
        SmartDashboard.putString("LaunchBallC", "interrupted");        
    }    
}
