package team3663.neon.commands;

public class P_ShiftToHighGear extends CommandBase 
{
    public P_ShiftToHighGear()
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
