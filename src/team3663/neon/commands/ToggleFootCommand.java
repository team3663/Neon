package team3663.neon.commands;

public class ToggleFootCommand extends CommandBase
{
    public ToggleFootCommand()
    {
        requires(ballHandler);
    }
    protected void initialize()
    {
        if(ballHandler.IsFootUp())
        {
            ballHandler.FootDown();
        }
        else
        {
            ballHandler.FootUp();
        }
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
