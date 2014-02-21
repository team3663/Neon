package team3663.neon.commands;

public class SwitchToLowGear extends CommandBase 
{
    public SwitchToLowGear()
    {
        requires(driveTrain);
    }
    protected void initialize()
    {
        driveTrain.ShiftToLowGear();
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
