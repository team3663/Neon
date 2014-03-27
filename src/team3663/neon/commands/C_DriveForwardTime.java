package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_DriveForwardTime extends CommandBase {
    
    double timeToWait;
    double endTime;  
    double speed;
    double twist;
    
    public C_DriveForwardTime(double pTimeWait, double pSpeed, double pTwist) {
        speed = pSpeed;
        twist = pTwist;
        timeToWait = pTimeWait;
       // requires(driveTrainSS);
    }

    protected void initialize() {
        SmartDashboard.putString("C_DriveForwardTime", "initialize");        
        endTime = Timer.getFPGATimestamp() + timeToWait;
    }

    protected void execute() {
        driveTrainSS.drive3663(0,speed, twist);
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("C_DriveForwardTime", "end");        
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
        SmartDashboard.putString("C_DriveForwardTime", "interrupted");        
        end();
    }
}
