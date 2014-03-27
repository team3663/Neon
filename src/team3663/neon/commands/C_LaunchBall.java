 package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_LaunchBall  extends CommandBase 
{
    public boolean isFinished;
    double endTime;
    
    // give the ball time to leave
    final double DURATION = 0.75;
    
    public C_LaunchBall()
    {
        requires(winchAndLatchSS);
    }
    
    protected void initialize()
    {
        // This must be done in initialize as the command could be run
        // long after it was created
        endTime = Timer.getFPGATimestamp() + DURATION;
        
        winchAndLatchSS.latchOpen();
        SmartDashboard.putString("C_LaunchBall", "initialize");        
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
        SmartDashboard.putString("C_LaunchBall", "end");        
    }
    
    protected void interrupted()
    {
        SmartDashboard.putString("C_LaunchBall", "interrupted");        
    }    
}
