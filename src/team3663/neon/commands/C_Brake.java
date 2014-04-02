package team3663.neon.commands;

public class C_Brake extends CommandBase {
    double lastRanEncoderValue;
    double distance;
    
    public C_Brake() {
    }
    
    protected void initialize() {
        driveTrainSS.drive3663(0, .5, 0);
        lastRanEncoderValue = driveTrainSS.GetRightEncoder();
    }
    
    protected void execute() {
        distance = driveTrainSS.GetRightEncoder() - lastRanEncoderValue;
        if (distance < 0)
        {
            distance = -distance;
        }
        if((distance < 4)&&(distance > -4))
        {
            distance = 0;
        }
    }
    
    protected boolean isFinished() {
        lastRanEncoderValue = driveTrainSS.GetRightEncoder();
        if(distance == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }
    
    protected void interrupted() {
        end();
    }
}
