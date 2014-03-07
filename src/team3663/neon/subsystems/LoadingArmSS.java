package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class LoadingArmSS extends Subsystem {
    public void initDefaultCommand() {
    }
    
    public void LoadingArmSS(){
    }
    
    public void LoadingArmDown(){
        RobotMap.loadingArmUpDownSolenoid1.set(true);
        RobotMap.loadingArmUpDownSolenoid2.set(false);
    }
    public void LoadingArmUp(){
        RobotMap.loadingArmUpDownSolenoid1.set(false);
        RobotMap.loadingArmUpDownSolenoid2.set(true);
    }
    public void LoadingArmMotorIntake(){
        RobotMap.LoadingArmSpeedController.set(-1.0);
    }
    public void LoadingArmMotorEject(){
        RobotMap.LoadingArmSpeedController.set(1.0);
    }
    public void LoadingArmMotorStop(){
        RobotMap.LoadingArmSpeedController.set(0.0);
    }
    //checks
    public boolean IsBallLoaded(){
        return RobotMap.ballLoadedLimitSwitchDIO.get();
    }
    public boolean IsLoadingArmUp(){
        return !RobotMap.loadingArmUpDownSolenoid1.get();
    }
}
