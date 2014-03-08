/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author curtis
 */
public class TimerC extends CommandBase {
    
    
    double endTime;
    double seconds;
    double startTime;
    double counter;
    public TimerC(double timeToWait) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        seconds = timeToWait;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        endTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp() + seconds;
        startTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        counter = endTime - startTime;
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "ETA tell fire = " + counter);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (edu.wpi.first.wpilibj.Timer.getFPGATimestamp() >= endTime)
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "ETA tell fire = READY TO FIRE");
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
