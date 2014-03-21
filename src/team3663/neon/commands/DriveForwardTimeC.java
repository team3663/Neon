package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardTimeC extends CommandBase {
    
    double timeToWait;
    double endTime;  
    
    public DriveForwardTimeC(double pTimeWait) {
        
        timeToWait = pTimeWait;
        requires(driveTrainSS);
    }

    protected void initialize() {
        SmartDashboard.putString("DriveForwardTimeC", "initialize");        
        System.out.println("DriveForwardTimeC.initialize");
        endTime = Timer.getFPGATimestamp() + timeToWait;
    }

    protected void execute() {
        driveTrainSS.drive3663(0,-1, 0);
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("DriveForwardTimeC", "end");        
        System.out.println("DriveForwardTimeC.end");
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
        SmartDashboard.putString("DriveForwardTimeC", "interrupted");        
        System.out.println("DriveForwardTimeC.interrupted");
        end();
    }
}
