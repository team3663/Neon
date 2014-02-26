/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.RobotMap;

/**
 *
 * @author Angelique
 */
public class Bob extends CommandBase {
    
    int i;
    public Bob() {
        System.out.println("Bob");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        i = 0;
        System.out.println("Bob.initialize");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Bob.execute");
        Timer.delay(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("Bob.isFinished & i = " + i);
        if (i < 10)
        {
            i++;
            return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Bob.end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("Bob.interrupted \n Karel Dear Stop interrupting me!");
    }
}
