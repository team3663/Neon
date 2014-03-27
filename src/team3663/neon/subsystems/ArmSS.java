package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;

public class ArmSS extends Subsystem {
    public void initDefaultCommand() {
    }
    
    public void ArmSS(){
        System.out.println("ArmSS constructor start");
        armUp();
        System.out.println("ArmSS constructor end");
    }
    
    public void armDown(){
        RobotMap.armUpDownSolenoid1.set(true);
        RobotMap.armUpDownSolenoid2.set(false);
    }
    public void armUp(){
        RobotMap.armUpDownSolenoid1.set(false);
        RobotMap.armUpDownSolenoid2.set(true);
    }
    public void armMotorIntake(){
        RobotMap.armSpeedController.set(-1.0);
    }
    public void armMotorEject(){
        RobotMap.armSpeedController.set(1.0);
    }
    public void armMotorStop(){
        RobotMap.armSpeedController.set(0.0);
    }
    public boolean armIsUp(){
        return RobotMap.armUpDownSolenoid2.get();
    }
    public void updateStatus()
    {
        if (armIsUp())
            SmartDashboard.putString("Arm", "up");
        else
            SmartDashboard.putString("Arm", "down");
        
        SmartDashboard.putNumber("Arm speed", RobotMap.armSpeedController.get());
    }
    
}
