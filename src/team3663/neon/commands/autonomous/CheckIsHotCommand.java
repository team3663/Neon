package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;
import team3663.neon.commands.CommandBase;

public class CheckIsHotCommand extends CommandBase 
{
    public double endTime;
    
    public CheckIsHotCommand() 
    {

    }
    
    protected void initialize() 
    {
        if(Robot3663.isTesting)
        {
            System.out.println("istesting auto");
            Robot3663.autoTimeStart = Timer.getFPGATimestamp();
        }
        
        System.out.println("Timer startAuto: "+Timer.getFPGATimestamp());
        endTime = Robot3663.autoTimeStart + 5.5;

    }
    
    protected void execute() {}
    
    protected boolean isFinished() 
    {
         if(CommandBase.isHot || Timer.getFPGATimestamp() > endTime)
         {
            return true;
         }
         return false;
    }
    
    protected void end() 
    {
        System.out.println("TImer endAuto: "+Timer.getFPGATimestamp());
    }
    
    protected void interrupted() {}
}
