package team3663.neon.commands;

public class RangeFinder extends CommandBase
{
    public RangeFinder()
    {
        requires(ultraSonic);
    }
    protected void initialize()
    {
        
    }
    protected void execute()
    {
        //ultraSonic.getDistanceInches();
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
