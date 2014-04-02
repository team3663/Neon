package team3663.neon.commands;

public class C_Drive extends CommandBase
{
    public C_Drive()
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

