package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_ShiftToHighGear extends CommandBase 
{
    double endTime;
    public P_ShiftToHighGear()
    {
        //requires(driveTrainSS);
    }
    
    protected void initialize()
    {
        SmartDashboard.putString("P_ShiftToHighGear", "initialize");        
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
        SmartDashboard.putString("P_ShiftToHighGear", "end");
    }
    
    public void interrupted(){
        SmartDashboard.putString("P_ShiftToHighGear", "interrupted");
    }
}
