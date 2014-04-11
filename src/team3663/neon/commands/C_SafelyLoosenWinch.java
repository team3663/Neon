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
public class C_SafelyLoosenWinch extends CommandBase {
    
    final double WAITTIME = .75;
    double endTime;
     
    public C_SafelyLoosenWinch() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        endTime = WAITTIME + Timer.getFPGATimestamp();
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(1);
    }

    protected boolean isFinished() {
        if(endTime <= Timer.getFPGATimestamp())
        {
            return true;
        }
        return false;
    }

    protected void end() {
        winchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        end();
    }
}
