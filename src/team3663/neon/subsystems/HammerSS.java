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

    // mustard code below (ketchup is flipped)
    public boolean hammerIsRetracted(){
        // mustard
        //return RobotMap.hammerRetractExtendSolenoid2.get();
        
        //ketchup
        return RobotMap.hammerRetractExtendSolenoid1.get();
    }
    
    public void hammerExtend(){
        //mustard
        //RobotMap.hammerRetractExtendSolenoid1.set(true);
        //RobotMap.hammerRetractExtendSolenoid2.set(false);        

        //ketchup
        RobotMap.hammerRetractExtendSolenoid1.set(false);
        RobotMap.hammerRetractExtendSolenoid2.set(true);        
    }
    
    public void hammerRetract(){
        //mustard
        //RobotMap.hammerRetractExtendSolenoid1.set(false);
        //RobotMap.hammerRetractExtendSolenoid2.set(true);

        //ketchup
        RobotMap.hammerRetractExtendSolenoid1.set(true);
        RobotMap.hammerRetractExtendSolenoid2.set(false);
    }
    public void updateStatus(){
        if (hammerIsRetracted())
            SmartDashboard.putString("Hammer ","retracted");
        else
            SmartDashboard.putString("Hammer ","extended");
    }
}
