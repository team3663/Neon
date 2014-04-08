package team3663.neon.commands.autonomous;
import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;
import team3663.neon.commands.CommandBase;

/*
 * @author Kainoa & Tyler
 */

public class TargetCommand extends CommandBase
{
    private double _endTime;
    
    public TargetCommand()
    {
        requires(imageProcess2);
    }
    protected void initialize()
    {  
        Robot3663.updateCommandStatus("TargetCommand", "initialize");        
        _endTime = Timer.getFPGATimestamp() + 2;
    }
    protected void execute() {}
    
    protected boolean isFinished()
    {
        imageProcess2.processCameraImage(false,false,false,false,1);

        if(imageProcess2.hotTargetFound())
        {
            return true;
        }
        if(Timer.getFPGATimestamp() > _endTime)
        {
            return true;
        }
        return true; //temporary
    }
    protected void end()
    {
        Robot3663.updateCommandStatus("TargetCommand", "end");        
        System.out.println("Target time: "+ (Timer.getFPGATimestamp()));
    }
    protected void interrupted() {}
}
