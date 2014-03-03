package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class HammerSS extends Subsystem {
            
    public void initDefaultCommand() {
    }
    
    public void Hammer(){
        hammerRetract();
    }
/** 
**don't know if this is sending the proper response
**/
    public boolean isHammerRetracted(){
        return RobotMap.hammerRetractExtendSolenoid2.get();
    }
    
    public void hammerExtend(){
        RobotMap.hammerRetractExtendSolenoid1.set(true);
        RobotMap.hammerRetractExtendSolenoid2.set(false);        
    }
    
    public void hammerRetract(){
        RobotMap.hammerRetractExtendSolenoid1.set(false);
        RobotMap.hammerRetractExtendSolenoid2.set(true);        
    }
}
