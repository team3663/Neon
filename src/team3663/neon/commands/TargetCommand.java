package team3663.neon.commands;

public class TargetCommand extends CommandBase
{
    public TargetCommand()
    {
        requires(imageProcess);
    }
    protected void initialize()
    {
        if(CheckForTarget(5))
        {
            System.out.println("Robot is facing the hot target");
        }
        else
        {
            System.out.println("No hot target found in autonomous");
        }
    }
    protected void execute()
    {
         
    }
    protected boolean isFinished()
    {
        return false;
    }
    protected void end()
    {
        
    }
    protected void interrupted()
    {
        
    }
    
    public boolean CheckForTarget(int passes)
    {
        for(int i = 0; i < passes; i++)
        {
            if(imageProcess.isGoalHot()){
                return true;
            }
        }
        return false;
    }
}
