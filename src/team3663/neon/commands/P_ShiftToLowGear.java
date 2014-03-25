package team3663.neon.commands;

public class P_ShiftToLowGear extends CommandBase 
{
    public P_ShiftToLowGear()
    {
        requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        driveTrainSS.ShiftToLowGear();
    }
    
    protected void execute(){
    }
    
    protected boolean isFinished(){
        return true;
    }
    
    public void end(){
    }
    
    public void interrupted(){
    }
}
