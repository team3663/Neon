package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_ShiftToHighGear extends CommandBase 
{
    double endTime;
    public P_ShiftToHighGear()
    {
        requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        endTime = Timer.getFPGATimestamp() + .25;
        driveTrainSS.ShiftToHighGear();
    }
    
    protected void execute(){
    }
    
    protected boolean isFinished()
    {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }
    
    public void end(){
    }
    
    public void interrupted(){
    }
}
