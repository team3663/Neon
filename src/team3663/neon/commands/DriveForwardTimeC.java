package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class DriveForwardTimeC extends CommandBase {
    
    double timeToWait;
    double endTime;  
    
    public DriveForwardTimeC(double pTimeWait) {
        
        timeToWait = pTimeWait;
        requires(driveTrainSS);
    }

    protected void initialize() {
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
        System.out.println("DriveForwardTimeC.end");
        driveTrainSS.drive3663(0, 0, 0);
    }

    protected void interrupted() {
        System.out.println("DriveForwardTimeC.interrupted");
        end();
    }
}
