package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_ShiftToHighGear extends CommandBase 
{
    double endTime;
    public P_ShiftToHighGear()
    {
        //requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        Robot3663.updateCommandStatus("P_ShiftToHighGear", "initialize");        
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
        Robot3663.updateCommandStatus("P_ShiftToHighGear", "end");
    }
    
    public void interrupted(){
        Robot3663.updateCommandStatus("P_ShiftToHighGear", "interrupted");
    }
}
