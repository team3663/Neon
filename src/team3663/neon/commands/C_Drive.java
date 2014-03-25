package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_Drive extends CommandBase
{
    public C_Drive()
    {   
        requires(driveTrainSS); 
    }

    protected void initialize(){
        SmartDashboard.putString("C_Drive", "Initialized");
    }

    protected void execute() 
    {
        double jX, jY, jZ;

        jX = oi.getDriveJoystick().getX();
        jY = oi.getDriveJoystick().getY();
        jZ = oi.getDriveJoystick().getZ(); // twist
        
        jZ = jZ*.75;

        driveTrainSS.drive3663(jX, jY, jZ);
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end(){
        SmartDashboard.putString("C_Drive", "End");
    }

    protected void interrupted(){
        SmartDashboard.putString("C_Drive", "Interrupted");
    }
}

