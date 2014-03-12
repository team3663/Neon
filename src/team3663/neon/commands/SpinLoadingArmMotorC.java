package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class SpinLoadingArmMotorC extends CommandBase {
    
    boolean intake;
    double endTime;
    double duration;
    
    public SpinLoadingArmMotorC(boolean pIntake, double pDuration) {
        intake = pIntake;
        duration = pDuration;
        requires(loadingArmSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + duration;
        if (intake)
            loadingArmSS.loadingArmMotorIntake();
        else
            loadingArmSS.loadingArmMotorEject();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        loadingArmSS.loadingArmMotorStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
