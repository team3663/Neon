/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;
/**
 *
 * @author TrentHashimoto
 */
public class Hammer extends Subsystem {
    
    public void Hammer(){
        RetractHammer();
    }
/** 
**don't know if this is sending the proper response
**/
    public boolean isHammerRetracted(){
        return RobotMap.hammerSolenoid2.get();
    }
    public void HitBall(){
        RobotMap.hammerSolenoid1.set(true);
        RobotMap.hammerSolenoid2.set(false);
        
    }
    
    public void RetractHammer(){
        RobotMap.hammerSolenoid1.set(false);
        RobotMap.hammerSolenoid2.set(true);
        
    }
    
    public void initDefaultCommand() {
    }
}
