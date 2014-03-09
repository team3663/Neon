package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class FootSS extends Subsystem {
    public void initDefaultCommand() {
    }
    
    public void FootSS(){
    }
    
    public void footUp(){
        RobotMap.footUpDownSolenoid1.set(true);
        RobotMap.footUpDownSolenoid2.set(false);
    }

    public void footDown(){
        RobotMap.footUpDownSolenoid1.set(false);
        RobotMap.footUpDownSolenoid2.set(true);
    }

    public boolean FootIsUp(){
        return RobotMap.footUpDownSolenoid1.get();
    }
}
