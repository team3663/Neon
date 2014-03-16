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
public class Bob extends CommandBase {
    double counter;
    
    public Bob() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        counter = 20 + Timer.getFPGATimestamp();
        System.out.println("Bob has Initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        System.out.println("bob is counting" + counter);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() > counter)
        {
            System.out.println("bob is returning true in is finshed");
            return true;
        }
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("bob has ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("bob was interruped");
        end();
    }
}
