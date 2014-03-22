package team3663.neon.commands;

public class DriveC extends CommandBase
{
    public DriveC()
    {   
        requires(driveTrainSS); 
    }

    protected void initialize(){
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
    }

    protected void interrupted(){
    }
}

