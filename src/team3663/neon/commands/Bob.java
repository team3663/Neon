/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author curtis
 */
public class Bob extends CommandBase {
    double endTime;
    double time;
    Command bob2;
    
    public Bob() {
        SmartDashboard.putNumber("Bob duration",7);
        bob2 = new Bob2();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double duration = SmartDashboard.getNumber("Bob duration");
        endTime = duration + Timer.getFPGATimestamp();
        System.out.println("Bob has Initialized, duration = "+ duration);
        SmartDashboard.putNumber("Bob's current duration:", duration);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        double currentTime = Timer.getFPGATimestamp();
        if( currentTime > endTime)
        {
            System.out.println("bob is done (isFinshed)");
            return true;
        }
        System.out.println("bob is running " + (endTime - currentTime));
        SmartDashboard.putNumber("Bob time:",(endTime - currentTime));
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("bob has ended");
        bob2.start();
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("bob was interruped");
        end();
    }
}
