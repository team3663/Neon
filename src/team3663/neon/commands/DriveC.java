package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveC extends CommandBase
{
    double left;
    double right;
    
    public DriveC()
    {   
        requires(driveTrainSS); 
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        double jX, jY, jZ, jTwist;
        
        jX = oi.getDriveJoystick().getX();
        jY = oi.getDriveJoystick().getY();
        jZ = oi.getDriveJoystick().getZ();
        jTwist = oi.getDriveJoystick().getTwist();

        SmartDashboard.putNumber("Joystick X:", jX);
        SmartDashboard.putNumber("Joystick Y:", jY);
        SmartDashboard.putNumber("Joystick Z:", jZ);
        SmartDashboard.putNumber("Joystick Twist:", jTwist);

        if(driveTrainSS.IsTractionDown())
       {
           driveTrainSS.Arcade(oi.getDriveJoystick().getX(), oi.getDriveJoystick().getY(), oi.getDriveJoystick().getZ());
           SmartDashboard.putString("Driving:", "Arcade");
       }
       else
       {
           driveTrainSS.Mecanum(oi.getDriveJoystick().getX(), oi.getDriveJoystick().getY(), oi.getDriveJoystick().getTwist());
           SmartDashboard.putString("Driving:", "Mecanum");
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

