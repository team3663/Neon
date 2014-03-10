package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;

public class ShooterWinchAndLatchSS extends Subsystem
{
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    
    public void initDefaultCommand()
    {
    }
    
    public void WinchAndLatchSS()
    {
        winchEncoderReset();
        latchClose();
        setWinchSpeed(0.0);
    }
    
    public void latchClose()
    {
        RobotMap.shooterLatchSolenoid1.set(false);
        RobotMap.shooterLatchSolenoid2.set(true);
    }
    public void latchOpen()
    {
        RobotMap.shooterLatchSolenoid1.set(true);
        RobotMap.shooterLatchSolenoid2.set(false);
    }
    
    public boolean latchIsOpen()
    {
        return RobotMap.shooterLatchSolenoid1.get();
    }
    
    public void setWinchSpeed(double speed)
    {
        RobotMap.shooterWinchSpeedController.set(speed);
    }
    
    public void winchEncoderReset()
    {
        RobotMap.winchEncoder.reset();
    }
    
    public double getWinchEncoder()
    {
        //one revolution is 360 ticks
        return RobotMap.winchEncoder.get();
    }
    
    public void UpdateStatus()
    {
        SmartDashboard.putNumber("WinchEncoder", getWinchEncoder());
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, "" + (int)getWinchEncoder());
    }
}
