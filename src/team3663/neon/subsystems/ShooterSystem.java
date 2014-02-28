package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class ShooterSystem extends Subsystem
{
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    
    public void initDefaultCommand()
    {
    }
    
    public void ShooterSystem()
    {
        wenchEncoderReset();
        closeLatch();
        setWench(0.0);
    }
    
    public void closeLatch(){
        RobotMap.shooterLatchSolenoid1.set(false);
        RobotMap.shooterLatchSolenoid2.set(true);
    }
    public void openLatch(){
        RobotMap.shooterLatchSolenoid1.set(true);
        RobotMap.shooterLatchSolenoid2.set(false);
    }
    
    public void setWench(double speed)
    {
        RobotMap.shooterSpeedController.set(speed);
    }
    
    public void wenchEncoderReset()
    {
        RobotMap.shooterEncoder.reset();
    }
    
    public double getShooterEncoder()
    {
        return RobotMap.shooterEncoder.get();
    }
    
    public boolean IsFlipperDown()
    {
        return RobotMap.shooterLimitSwitch.get();
    }
    
    public boolean IsBallLoaded()
    {
        return RobotMap.ballLimitSwitch.get();
    }
}
