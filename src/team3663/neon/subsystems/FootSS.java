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
        RobotMap.footUpDownSolenoid1.set(true);
        RobotMap.footUpDownSolenoid2.set(false);
    }

    public void footDown(){
        RobotMap.footUpDownSolenoid1.set(false);
        RobotMap.footUpDownSolenoid2.set(true);
    }

    public boolean footIsUp(){
        return RobotMap.footUpDownSolenoid1.get();
    }
    public void updateStatus(){
        SmartDashboard.putBoolean("Foot is up: ", footIsUp());
    }
}
