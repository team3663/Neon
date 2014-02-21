package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightWithEncoders extends Command
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
        requires(CommandBase.driveTrain);
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
        CommandBase.driveTrain.ResetDriveEncoders();
    }
    
    protected void execute()
    {
        CommandBase.driveTrain.Drive(driveSpeed, 0.0);
    }
    
    protected boolean isFinished()
    {
        if(isDrivingForward){
            if(CommandBase.driveTrain.GetRightEncoder()>finalEncoderCount){
                return true;
            }
        }
        else{
            if(CommandBase.driveTrain.GetRightEncoder()<finalEncoderCount){
                return true;
            }
        }
        return false;
    }
    
    protected void end()
    {
        CommandBase.driveTrain.Stop();
    }
    
    protected void interrupted()
    {
        end();
    }
    
}
