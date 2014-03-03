package team3663.neon.commands;

public class ShiftToLowGearC extends CommandBase 
{
    public ShiftToLowGearC()
    {
        requires(driveTrainSS);
    }
    protected void initialize()
    {
        driveTrainSS.ShiftToLowGear();
    }
    protected void execute()
    {
        
    }
    protected boolean isFinished()
    {
        return true;
    }
    public void end()
    {
        
    }
    public void interrupted()
    {
        
    }
    
}
