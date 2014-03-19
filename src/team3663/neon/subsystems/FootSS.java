package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;

public class FootSS extends Subsystem {
    public void initDefaultCommand() {
    }
    
    public void FootSS(){
        System.out.println("FootSS constructor start");
        footUp();
        System.out.println("FootSS constructor end");
    }
    
    public void footUp(){
        // mustard RobotMap.footUpDownSolenoid1.set(false);
        // mustard RobotMap.footUpDownSolenoid2.set(true);

        // ketchup
        RobotMap.footUpDownSolenoid1.set(true);
        RobotMap.footUpDownSolenoid2.set(false);
    }

    public void footDown(){
        // mustard RobotMap.footUpDownSolenoid1.set(true);
        // mustard RobotMap.footUpDownSolenoid2.set(false);

        // ketchup
        RobotMap.footUpDownSolenoid1.set(false);
        RobotMap.footUpDownSolenoid2.set(true);
    }

    public boolean footIsUp(){
        // mustard return RobotMap.footUpDownSolenoid2.get();
        
        // ketchup
        return RobotMap.footUpDownSolenoid1.get();
    }
    public void updateStatus(){
        if(footIsUp())
            SmartDashboard.putString("Foot ","up");
        else
            SmartDashboard.putString("Foot ","down");
    }
}
