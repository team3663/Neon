package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;

public class FootSS extends Subsystem {

    public void initDefaultCommand() {
    }
    
    public void FootSS(){
        footUp();
    }
    
    public void footUp(){
        RobotMap.footUpDownSolenoid1.set(false);
        RobotMap.footUpDownSolenoid2.set(true);
    }

    public void footDown(){
        RobotMap.footUpDownSolenoid1.set(true);
        RobotMap.footUpDownSolenoid2.set(false);
    }

    public boolean footIsUp(){
        return RobotMap.footUpDownSolenoid2.get();
    }
    
    public void updateStatus(){
        if(footIsUp())
            SmartDashboard.putString("Foot ","up");
        else
            SmartDashboard.putString("Foot ","down");
    }
}
