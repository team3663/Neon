/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;
import team3663.neon.commands.CatapultLimitSwitchMonitorC;

/**
 *
 * @author briking
 */
public class CatapultLimitSwitchSS extends Subsystem {
    boolean catapultIsReallyDown;
        
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CatapultLimitSwitchMonitorC());
    }
    
    public boolean catapultIsDownRaw()
    {
        return !RobotMap.shooterLimitSwitchDIO.get();
    }
    
    public boolean catapultIsDown()
    {
        return catapultIsReallyDown;
    }
    
    public void putCatapultIsDown(boolean pCatapultState)
    {
        catapultIsReallyDown = pCatapultState;
    }
    
    
}
