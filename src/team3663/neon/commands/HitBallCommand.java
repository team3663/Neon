package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class HitBallCommand extends CommandBase
{
    public HitBallCommand()
    {
        requires(hammer);
    }
    
    protected void initialize()
    {
        hammer.HitBall();
        Timer.delay(0.25);
        hammer.RetractHammer();
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
        end();
    }
}
