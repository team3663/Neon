package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;

public class HammerSS extends Subsystem {
            
    public void initDefaultCommand() {
    }
    
    public void HammerSS(){
        System.out.println("HammerSS constructor start");
        hammerRetract();
        System.out.println("HammerSS constructor end");
    }

    public boolean hammerIsRetracted(){
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
    public void updateStatus(){
        if (hammerIsRetracted())
            SmartDashboard.putString("Hammer","Hammer is retracted");
        else
            SmartDashboard.putString("Hammer","Hammer is extended");
    }
}
