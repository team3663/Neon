/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author curtis
 */
public class DriveForwardTimeC extends CommandBase {
    
    double timeToWait;
    double endTime;
    
    public DriveForwardTimeC(double pTimeWait) {
        timeToWait = pTimeWait;
        // Use requires() here to declare subsystem dependencies
        requires(driveTrainSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + timeToWait;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrainSS.Drive(0.5, 0);
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
        driveTrainSS.Drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
