/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.Robot3663;

/**
 *
 * @author briking
 */
public class C_CameraDetectHotGoal extends CommandBase {
    
    double endTime;
    
    public C_CameraDetectHotGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + 2;
        imageProcess2.processCameraImage(Robot3663.dontUseCamera, true, false, false, 1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
 
        if (Timer.getFPGATimestamp() > endTime)
            return true;
        
        if (imageProcess2.hotTargetFound())
            return true;
        
        imageProcess2.processCameraImage(Robot3663.dontUseCamera, false, false, false, 1);
        
        return imageProcess2.hotTargetFound();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
