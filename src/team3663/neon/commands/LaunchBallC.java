 package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LaunchBallC  extends CommandBase 
{
    public boolean isFinished;
    double endTime;
    
    // give the ball time to leave
    final double DURATION = 0.75;
    
    public LaunchBallC()
    {
        requires(shooterWinchAndLatchSS);
    }
    
    protected void initialize()
    {
        // This must be done in initialize as the command could be run
        // long after it was created
        endTime = Timer.getFPGATimestamp() + DURATION;
        
        shooterWinchAndLatchSS.latchOpen();
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
    }
    
    protected void interrupted()
    {
    }
    
}
