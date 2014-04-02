package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

public class P_HammerRetract extends CommandBase
{
    double endTime;
    public P_HammerRetract()
    {
        requires(hammerSS);
    }
    
    protected void initialize(){
        Robot3663.updateCommandStatus("P_HammerRetract", "initialize");        
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
        Robot3663.updateCommandStatus("P_HammerRetract", "end");
    }
    
    protected void interrupted(){
        Robot3663.updateCommandStatus("P_HammerRetract", "interrupted");
    }
}
