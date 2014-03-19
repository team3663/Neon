package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.commands.CommandBase;

public class EncoderDrive extends CommandBase
{
    private double targetDistance;
    private double driveSpeed;
    private boolean isFinished;
    
    public EncoderDrive(double distance, double speed)
    {
        requires(driveTrainSS);
        targetDistance = distance;
        driveSpeed = speed;
        isFinished = false;
        //setTimeout(10.0);
    }
    
    protected void initialize()
    {
        timer = new Timer();
        CommandBase.driveTrainSS.DriveEncoderReset();
    }
    
    protected void execute()
    {
        if (driveTrainSS.GetTotalDistance() <= targetDistance)
        {
                driveTrainSS.drive3663(0, driveSpeed, 0/*driveTrainSS.EncoderError()*/);//995 988 992 991.875
        }
        else
        {
            driveTrainSS.drive3663(0, 0, 0);
            isFinished = true;
        }
        
        double encodeCorrect = driveTrainSS.GetTotalDistance();
        System.out.println("encoders: " + encodeCorrect);
        System.out.println("Left: "+driveTrainSS.GetLeftDistance()+"Right: "+driveTrainSS.GetRightDistance());
    }
    
    protected boolean isFinished()
    {
        return isFinished /*|| isTimedOut()*/;
    }
    
    protected void end()
    {
        driveTrainSS.drive3663(0, 0, 0);
    }
    
    protected void interrupted()
    {
        end();
    }
    
}
