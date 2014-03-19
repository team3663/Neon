/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

/**
 *
 * @author curtis
 */
public class AutonomousBackUpUsingEncodersC extends CommandBase {
    private double encoderLeft;
    private double encoderRight;
    int finalEncoderWantedVal = 1180;
    
    public AutonomousBackUpUsingEncodersC() {
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrainSS.ResetDriveEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrainSS.drive3663(0,-.7, 0);
        encoderLeft = driveTrainSS.GetLeftEncoder();
        encoderRight = driveTrainSS.GetRightEncoder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if((encoderRight > finalEncoderWantedVal)||(encoderLeft > finalEncoderWantedVal))
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
