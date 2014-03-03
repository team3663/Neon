package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChectForHotZoneC extends CommandBase
{
    public ChectForHotZoneC()
    {
        requires(imageProcessingSS);
    }
    protected void initialize()
    {
    }
    
    protected void execute()
    {
        System.out.println("The image processing is being called");
        if(imageProcessingSS.isGoalHot())
        {
            SmartDashboard.putString("Hot or Cold", "Hot");
            System.out.println("Robot is facing the hot target");
        }
        else
        {
            SmartDashboard.putString("Hot or Cold", "Cold");
            System.out.println("No hot target found in autonomous");
        }
        System.out.println("The image processing is done");
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
