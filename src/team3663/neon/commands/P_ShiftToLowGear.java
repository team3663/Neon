package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_ShiftToLowGear extends CommandBase 
{
    double endTime;
    public P_ShiftToLowGear()
    {
        requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        endTime = Timer.getFPGATimestamp() + 0.25;
        driveTrainSS.ShiftToLowGear();
    }
    
    protected void execute(){
    }
    
    protected boolean isFinished(){
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
