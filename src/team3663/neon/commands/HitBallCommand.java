package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class HitBallCommand extends CommandBase
{
    double startTime;
    boolean done;
    
    public HitBallCommand()
    {
        requires(hammer);
        startTime = Timer.getFPGATimestamp();
    }
    
    protected void initialize()
    {
        hammer.HitBall();
    }
    
    protected void execute()
    {
        if (Timer.getFPGATimestamp() >= (startTime + 0.25))
        {
            hammer.RetractHammer();
            done = true;
        }
        else
        {
            done = false;
        }
    }
    
    protected boolean isFinished()
    {
        if (done)
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
        end();
    }
}
