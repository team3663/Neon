package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class RetractHammerCommand extends CommandBase
{
    public RetractHammerCommand()
    {
        requires(hammer);
    }
    
    protected void initialize()
    {
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
    }
}
