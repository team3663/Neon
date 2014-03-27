/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author briking
 */
public class Bob2 extends CommandBase {
    double endTime;
    double time;
    
    public Bob2() {
        SmartDashboard.putNumber("Bob2 duration",7);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double duration = SmartDashboard.getNumber("Bob2 duration");
        endTime = duration + Timer.getFPGATimestamp();
        System.out.println("Bob2 has Initialized, duration = "+ duration);
        SmartDashboard.putNumber("Bob2's current duration:", duration);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        double currentTime = Timer.getFPGATimestamp();
        if( currentTime > endTime)
        {
            System.out.println("bob2 is done (isFinshed)");
            return true;
        }
        System.out.println("bob2 is running " + (endTime - currentTime));
        SmartDashboard.putNumber("Bob2 time:",(endTime - currentTime));
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("bob2 has ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("bob2 was interruped");
        end();
    }
}
