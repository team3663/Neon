/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

/**
 *
 * @author briking
 */
public class ResetWinchEncoderC extends CommandBase {
    
    public ResetWinchEncoderC() {
        // Use requires() here to declare subsystem dependencies
        requires(shooterWinchAndLatchSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterWinchAndLatchSS.winchEncoderReset();
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
