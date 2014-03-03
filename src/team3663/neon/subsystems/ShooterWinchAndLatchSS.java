package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class ShooterWinchAndLatchSS extends Subsystem
{
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    
    public void initDefaultCommand()
    {
    }
    
    public void ShooterWinchAndLatch()
    {
        winchEncoderReset();
        closeLatch();
        setWinch(0.0);
    }
    
    public void closeLatch(){
        RobotMap.shooterLatchSolenoid1.set(false);
        RobotMap.shooterLatchSolenoid2.set(true);
    }
    public void openLatch(){
        RobotMap.shooterLatchSolenoid1.set(true);
        RobotMap.shooterLatchSolenoid2.set(false);
    }
    
    public void setWinch(double speed)
    {
        RobotMap.shooterWinchSpeedController.set(speed);
    }
    
    public void winchEncoderReset()
    {
        RobotMap.shooterEncoder.reset();
    }
    
    public double getShooterEncoder()
    {
        return RobotMap.shooterEncoder.get();
    }
    
    public boolean IsFlipperDown()
    {
        return RobotMap.shooterLimitSwitchDIO.get();
    }
    
    public boolean IsBallLoaded()
    {
        return RobotMap.ballLoadedLimitSwitchDIO.get();
    }
}
