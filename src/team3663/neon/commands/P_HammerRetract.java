package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_HammerRetract extends CommandBase
{
    double endTime;
    public P_HammerRetract()
    {
        requires(hammerSS);
    }
    
    protected void initialize(){
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
    
    protected void end()
    {
    }
    
    protected void interrupted()
    {
    }
}
