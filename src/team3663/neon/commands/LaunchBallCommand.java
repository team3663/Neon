 package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LaunchBallCommand  extends CommandBase 
{
    public boolean isFinished;
    double startTime;
    
    public LaunchBallCommand()
    {
        requires(shooterSystem);
        startTime = Timer.getFPGATimestamp();
    }
    
    protected void initialize()
    {
        shooterSystem.openLatch();
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
