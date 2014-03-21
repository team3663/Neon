package team3663.neon.commands;

public class ShiftToHighGearC extends CommandBase 
{
    public ShiftToHighGearC()
    {
        requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        driveTrainSS.ShiftToHighGear();
    }
    
    protected void execute(){
    }
    
    protected boolean isFinished()
    {
        return true;
    }
    
    public void end(){
    }
    
    public void interrupted(){
    }
}
