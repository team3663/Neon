package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_ShiftToLowGear extends CommandBase 
{
    double endTime;
    public P_ShiftToLowGear()
    {
        requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        SmartDashboard.putString("P_ShiftToLowGear", "initialize");        
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
        SmartDashboard.putString("P_ShiftToLowGear", "end");
    }
    
    public void interrupted(){
        SmartDashboard.putString("P_ShiftToLowGear", "interrupted");
    }
}
