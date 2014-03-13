package team3663.neon.commands.autonomous;
import team3663.neon.commands.CommandBase;

/*
 * @author Kainoa & Tyler
 */

public class TargetCommand extends CommandBase
{
    private boolean isFinished;
    public TargetCommand()
    {
        requires(imageProcess);
        isFinished = false;
    }
    protected void initialize()
    {
        //AutonomousInformation autoInfo = new AutonomousInformation();
        if(CheckForTarget(2))
        {
            isHot = true;
            System.out.println("hot target Left in autonomous: " + imageProcess.getHotIsLeft());
            System.out.println("target isHot: " + isHot);
            isFinished = true;
        }
        else
        {
            isHot = false;
            System.out.println("No hot target found in autonomous");
            System.out.println("target isHot: " + isHot);
            isFinished = true;
        }
    }
    protected void execute()
    {
         
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end()
    {
        
    }
    protected void interrupted()
    {
        
    }
    
    public boolean CheckForTarget(int passes)
    {
        int count = 0;
        for(int i = 0; i < passes; i++)
        {
            imageProcess.processCameraImage();
            if(imageProcess.hotTargetFound())
            {
                count++;
            }
        }
        System.out.println("count of hot targets: "+count);
        if(count >= 1)
        {
            return true;
        }
        return false;
        
    }
}