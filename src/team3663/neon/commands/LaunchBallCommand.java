package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LaunchBallCommand  extends CommandBase 
{
    public boolean isFinished;
    
    public LaunchBallCommand()
    {
        requires(shooterSystem);
    }
    
    protected void initialize()
    {
        shooterSystem.openLatch();
        Timer.delay(0.75);
    }
    
    protected void execute()
    {
      
    }
    
    protected boolean isFinished()
    {
        return true;
    }
    
    protected void end()
    {

    }
    
    protected void interrupted()
    {
        
    }
    
}
