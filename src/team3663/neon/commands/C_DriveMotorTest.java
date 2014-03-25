package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class C_DriveMotorTest extends CommandBase {
    int motorNumber;
    double endTime;
    double speed;
    double duration;
    
    public C_DriveMotorTest(int pRobotNumber, double pDuration, double pSpeed) {
        motorNumber = pRobotNumber;
        duration = pDuration;
        speed = pSpeed;
        requires(driveTrainSS);
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + duration;
    }

    protected void execute() {
        switch (motorNumber){
            case 1:
                driveTrainSS.driveBackLeftSpeedController(speed);
                break;
            case 2:
                driveTrainSS.driveBackRightSpeedController(speed);
                break;
            case 3:
                driveTrainSS.driveFrontLeftSpeedController(speed);
                break;
            case 4:
                driveTrainSS.driveFrontRightSpeedController(speed);
                break;
        }
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        switch (motorNumber){
            case 1:
                driveTrainSS.driveBackLeftSpeedController(0);
                break;
            case 2:
                driveTrainSS.driveBackRightSpeedController(0);
                break;
            case 3:
                driveTrainSS.driveFrontLeftSpeedController(0);
                break;
            case 4:
                driveTrainSS.driveFrontRightSpeedController(0);
                break;
        }
    }

    protected void interrupted() {
        end();
    }
}
