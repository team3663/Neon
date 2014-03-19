package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LoadingArmDownC extends CommandBase {
    
    double startTime;
    public LoadingArmDownC() {
        // Use requires() here to declare subsystem dependencies
     //   requires(loadingArmSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("LoadingArmDownC.initalize");
        loadingArmSS.loadingArmDown();
        startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() - startTime > .5)
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("LoadingArmDownC.end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("LoadingArmDownC.interrupted");
    }
}
