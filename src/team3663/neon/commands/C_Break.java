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
public class C_Break extends CommandBase {
    double lastRanEncoderValue;
    double distance;
    
    public C_Break() {
    }
    
    protected void initialize() {
        driveTrainSS.drive3663(0, .5, 0);
        lastRanEncoderValue = driveTrainSS.GetRightEncoder();
    }
    
    protected void execute() {
        distance = driveTrainSS.GetRightEncoder() - lastRanEncoderValue;
        if (distance < 0)
        {
            distance = -distance;
        }
        if((distance < 4)&&(distance > -4))
        {
            distance = 0;
        }
    }
    
    protected boolean isFinished() {
        lastRanEncoderValue = driveTrainSS.GetRightEncoder();
        if(distance == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    protected void end() {
        driveTrainSS.drive3663(0, 0, 0);
    }
    
    protected void interrupted() {
        end();
    }
}
