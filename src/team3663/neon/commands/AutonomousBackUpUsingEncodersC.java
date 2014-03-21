package team3663.neon.commands;

public class AutonomousBackUpUsingEncodersC extends CommandBase {
    private double encoderLeft;
    private double encoderRight;
    int finalEncoderWantedVal = 1180;
    
    public AutonomousBackUpUsingEncodersC() {
    }

    protected void initialize() {
        driveTrainSS.ResetDriveEncoders();
    }

    protected void execute() {
        driveTrainSS.drive3663(0,-.7, 0);
        encoderLeft = driveTrainSS.GetLeftEncoder();
        encoderRight = driveTrainSS.GetRightEncoder();
    }

    protected boolean isFinished() {
        if((encoderRight > finalEncoderWantedVal)||(encoderLeft > finalEncoderWantedVal))
        {
            return true;
        }
        return false;
    }

    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
    }
}
