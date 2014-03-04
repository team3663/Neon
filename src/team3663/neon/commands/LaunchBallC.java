 package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LaunchBallC  extends CommandBase 
{
    public boolean isFinished;
    double startTime;
    
    public LaunchBallC()
    {
        requires(shooterWinchAndLatchSS);
        startTime = Timer.getFPGATimestamp();
    }
    
    protected void initialize()
    {
        shooterWinchAndLatchSS.latchOpen();
    }
    
    protected void execute()
    {
        
    }
    
    protected boolean isFinished()
    {
        if (Timer.getFPGATimestamp() >= (startTime + 0.75))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    protected void end()
    {

    }
    
    protected void interrupted()
    {
        
    }
    
}
