package team3663.neon.commands;

public class DriveCommand extends CommandBase
{
    double left;
    double right;
    
    public DriveCommand()
    {   
            requires(driveTrain); 
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {           
       if(driveTrain.IsTractionDown())
       {
           driveTrain.Arcade(oi.getDriveJoystick().getX(), oi.getDriveJoystick().getY(), oi.getDriveJoystick().getZ());
       }
       else
       {
           driveTrain.Mechanum(oi.getDriveJoystick().getX(), oi.getDriveJoystick().getY(), oi.getDriveJoystick().getTwist());
       }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        
    }
}

