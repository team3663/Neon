package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightWithEncoders extends CommandBase
{
    private double destination;
    private double driveSpeed;
    private double curve;
    private double driveProgress;
    private double driveDirection;
    private boolean isDrivingForward;
    private double finalEncoderCount;
    
    public DriveStraightWithEncoders(double pFinalEncoderCount)
    {
        requires(driveTrain);
        finalEncoderCount = pFinalEncoderCount;
        
        if(finalEncoderCount > 0)
        {
            driveDirection = 1;
            isDrivingForward = true;
        }
        else
        {
            driveDirection = -1;
            isDrivingForward = false;
        }
        
        driveSpeed = driveDirection * 0.5;
    }
    
    protected void initialize()
    {
        driveTrain.ResetDriveEncoders();
    }
    
    protected void execute()
    {
        driveTrain.Drive(driveSpeed, 0.0);
    }
    
    protected boolean isFinished()
    {
        double rEncoder = driveTrain.GetRightEncoder();
        
        if(isDrivingForward){
            SmartDashboard.putNumber("Right Encoder remaing ticks:", rEncoder-finalEncoderCount);
            if(rEncoder>finalEncoderCount){
                return true;
            }
        }
        else{
            SmartDashboard.putNumber("Right Encoder remaing ticks:", finalEncoderCount-rEncoder);
            if(rEncoder<finalEncoderCount){
                return true;
            }
        }
        return false;
    }
    
    protected void end()
    {
        driveTrain.Stop();
    }
    
    protected void interrupted()
    {
        end();
    }
}
