package team3663.neon.commands;

public class SwitchToHighGear extends CommandBase 
{
    public SwitchToHighGear()
    {
        requires(driveTrain);
    }
    protected void initialize()
    {
        driveTrain.ShiftToHighGear();
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
