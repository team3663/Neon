/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author curtis
 */
public class ShooterLatchOpenC extends CommandBase {
    
    double startTime;
    
    public ShooterLatchOpenC() {
        // Use requires() here to declare subsystem dependencies
        requires(shooterWinchAndLatchSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("SHooterLatchOpenC.initialize");
        shooterWinchAndLatchSS.latchOpen();
        startTime = Timer.getFPGATimestamp();
       CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~~~DO NOT FIRE~~~");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("SHooterLatchOpenC.execute");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("SHooterLatchOpenC.isFinshed");
        if(Timer.getFPGATimestamp() - startTime > 1)
        {
            return true;
        }
        if(catapultLimitSwitchSS.catapultIsDown())
        {
            return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("SHooterLatchOpenC.end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("SHooterLatchOpenC.interrupted");
    }
}
