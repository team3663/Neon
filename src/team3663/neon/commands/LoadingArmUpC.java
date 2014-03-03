package team3663.neon.commands;

import team3663.neon.subsystems.LoadingArmSS;

public class LoadingArmUpC extends CommandBase {
    
    public LoadingArmUpC() {
        // Use requires() here to declare subsystem dependencies
        requires(loadingArmSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        loadingArmSS.LoadingArmUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
