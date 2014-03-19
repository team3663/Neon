package team3663.neon.commands.autonomous;
import edu.wpi.first.wpilibj.Timer;
import team3663.neon.commands.CommandBase;

/*
 * @author Kainoa & Tyler
 */

public class TargetCommand extends CommandBase
{
    private double _endTime;
    
    public TargetCommand()
    {
        requires(imageProcess);
    }
    protected void initialize()
    {  
        _endTime = Timer.getFPGATimestamp() + 2;
    }
    protected void execute() {}
    
    protected boolean isFinished()
    {
        imageProcess.processCameraImage();

        if(imageProcess.hotTargetFound())
        {
            isHot = true;
            return true;
        }
        if(Timer.getFPGATimestamp() > _endTime)
        {
            return true;
        }
        return false;
    }
    protected void end()
    {
        System.out.println("Target time: "+ (Timer.getFPGATimestamp()));
    }
    protected void interrupted() {}
}
