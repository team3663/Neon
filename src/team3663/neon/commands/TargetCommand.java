package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetCommand extends CommandBase
{
    public TargetCommand()
    {
        requires(imageProcess);
    }
    protected void initialize()
    {
        System.out.println("The image processing is being called");
        System.out.println("The second message is displayed");
        if(imageProcess.isGoalHot())
        {
            SmartDashboard.putString("Hot or Cold", "Hot");
            System.out.println("Robot is facing the hot target");
        }
        else
        {
            SmartDashboard.putString("Hot or Cold", "Cold");
            System.out.println("No hot target found in autonomous");
        }
    }
    protected void execute()
    {
         
    }
    protected boolean isFinished()
    {
        return true;
    }
    protected void end()
    {
        
    }
    protected void interrupted()
    {
        
    }
}
