package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_DriveForwardTime extends CommandBase {
    
    double timeToWait;
    double endTime;  
    double speed;
    
    public C_DriveForwardTime(double pTimeWait, double pSpeed) {
        speed = pSpeed;
        timeToWait = pTimeWait;
        requires(driveTrainSS);
        SmartDashboard.putNumber("drive forward time speed", speed);
        SmartDashboard.putNumber("drive forward time time ", timeToWait);
    }

    protected void initialize() {
       // speed = SmartDashboard.getNumber("drive forward time speed");
       //timeToWait = SmartDashboard.getNumber("drive forward time time ");
        SmartDashboard.putString("C_DriveForwardTime", "initialize");        
        endTime = Timer.getFPGATimestamp() + timeToWait;
    }

    protected void execute() {
        driveTrainSS.drive3663(0,speed, 0);
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
