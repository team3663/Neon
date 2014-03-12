package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;

public class LoadingArmSS extends Subsystem {
    public void initDefaultCommand() {
    }
    
    public void LoadingArmSS(){
        System.out.println("LoadingArmSS constructor start");
        loadingArmUp();
        System.out.println("LoadingArmSS constructor end");
    }
    
    public void loadingArmDown(){
        RobotMap.loadingArmUpDownSolenoid1.set(true);
        RobotMap.loadingArmUpDownSolenoid2.set(false);
    }
    public void loadingArmUp(){
        RobotMap.loadingArmUpDownSolenoid1.set(false);
        RobotMap.loadingArmUpDownSolenoid2.set(true);
    }
    public void loadingArmMotorIntake(){
        RobotMap.LoadingArmSpeedController.set(-1.0);
    }
    public void loadingArmMotorEject(){
        RobotMap.LoadingArmSpeedController.set(1.0);
    }
    public void loadingArmMotorStop(){
        RobotMap.LoadingArmSpeedController.set(0.0);
    }
    public boolean loadingArmIsUp(){
        return RobotMap.loadingArmUpDownSolenoid2.get();
    }
    public void updateStatus()
    {
        if (loadingArmIsUp())
            SmartDashboard.putString("LoadingArm", "Loading arm is up");
        else
            SmartDashboard.putString("LoadingArm", "Loading arm is down");
        
        SmartDashboard.putNumber("LoadingArm Motor: ", RobotMap.LoadingArmSpeedController.get());
    }
    
}
