/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author briking
 */
public class CatapultLimitSwitchMonitorC extends CommandBase {
    
    boolean catapultWasPreviouslyDown;
    boolean catapultIsReallyDown;
    double whenCatapultWentDown;
    
    public CatapultLimitSwitchMonitorC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        whenCatapultWentDown = 0;
//        if (catapultLimitSwitchSS.catapultIsDownRaw())
            catapultIsReallyDown = catapultWasPreviouslyDown = true;
//        else
            catapultIsReallyDown = catapultWasPreviouslyDown = false;
//        catapultLimitSwitchSS.putCatapultIsDown(catapultIsReallyDown);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    /*
        boolean catapultIsCurrentlyDown = catapultLimitSwitchSS.catapultIsDownRaw();

        if (!catapultIsCurrentlyDown)
        {
            catapultWasPreviouslyDown = false;
            catapultIsReallyDown = false;
        }
        else
        {
            double currentTime = Timer.getFPGATimestamp();
            if (!catapultWasPreviouslyDown)
            {
                catapultWasPreviouslyDown = true;
                whenCatapultWentDown = currentTime;
            }
            else if (!catapultIsReallyDown)
            {
                if (currentTime - whenCatapultWentDown > .25)
                {
                    catapultIsReallyDown = true;
                }
            }
        }
        catapultLimitSwitchSS.putCatapultIsDown(catapultIsReallyDown);  
    */
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
