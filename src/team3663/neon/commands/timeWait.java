/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Angelique
 */
public class timeWait extends CommandBase {
    
    double endTime;
    double seconds;
    
    public timeWait(double timeToWait) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        seconds = timeToWait;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + seconds;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
