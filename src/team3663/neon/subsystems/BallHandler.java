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
public class BallHandler extends Subsystem {
    public void initDefaultCommand() {
    }
    public void BallHandler(){
        LoadingArmMotorStop();
        LoadingArmUp();
        FootUp();
    }
    
    public void LoadingArmDown(){
        RobotMap.pickUpSolenoid1.set(true);
        RobotMap.pickUpSolenoid2.set(false);
    }
    public void LoadingArmUp(){
        RobotMap.pickUpSolenoid1.set(false);
        RobotMap.pickUpSolenoid2.set(true);
    }
    public void FootUp(){
        RobotMap.footSolenoid1.set(true);
        RobotMap.footSolenoid2.set(false);
    }
    public void FootDown(){
        RobotMap.footSolenoid1.set(false);
        RobotMap.footSolenoid2.set(true);
    }
    public void LoadingArmMotorIntake(){
        RobotMap.pickUpSpeedController.set(1.0);
    }
    public void LoadingArmMotorEject(){
        RobotMap.pickUpSpeedController.set(-1.0);
    }
    public void LoadingArmMotorStop(){
        RobotMap.pickUpSpeedController.set(0.0);
    }
    //checks
    public boolean IsBallLoaded(){
        return RobotMap.ballLimitSwitch.get();
    }
    public boolean IsFootUp(){
        return RobotMap.footSolenoid1.get();
    }
    public boolean IsLoadingArmUp(){
        return !RobotMap.pickUpSolenoid1.get();
    }
}
