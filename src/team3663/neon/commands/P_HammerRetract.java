package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class P_HammerRetract extends CommandBase
{
    double endTime;
    public P_HammerRetract()
    {
        requires(hammerSS);
    }
    
    protected void initialize(){
        SmartDashboard.putString("P_HammerRetract", "initialize");        
        endTime = Timer.getFPGATimestamp() + .5;
    }
    
    protected void execute()
    {
        hammerSS.hammerRetract();
    }
    
    protected boolean isFinished()
    {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }
    
    protected void end(){
        SmartDashboard.putString("P_HammerRetract", "end");
    }
    
    protected void interrupted(){
        SmartDashboard.putString("P_HammerRetract", "interrupted");
    }
}
