package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_ShiftToLowGear extends CommandBase 
{
    double endTime;
    public P_ShiftToLowGear()
    {
        //requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        Robot3663.updateCommandStatus("P_ShiftToLowGear", "initialize");        
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
        Robot3663.updateCommandStatus("P_ShiftToLowGear", "end");
    }
    
    public void interrupted(){
        Robot3663.updateCommandStatus("P_ShiftToLowGear", "interrupted");
    }
}
