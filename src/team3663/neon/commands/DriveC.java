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

    protected void initialize() 
    {
    }

    protected void execute() 
    {
        double jX, jY, jZ;
        
        jX = oi.getDriveJoystick().getX();
        jY = oi.getDriveJoystick().getY();
        jZ = oi.getDriveJoystick().getZ(); // twist

        SmartDashboard.putNumber("Joystick X:", jX);
        SmartDashboard.putNumber("Joystick Y:", jY);
        SmartDashboard.putNumber("Joystick Z:", jZ);

        if(driveTrainSS.TractionIsDown())
       {
           driveTrainSS.Arcade(jY, jZ);
           SmartDashboard.putString("Driving:", "Arcade");
       }
       else
       {
           driveTrainSS.Mecanum(jX, jY, jZ);
           SmartDashboard.putString("Driving:", "Mecanum");
       }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}

