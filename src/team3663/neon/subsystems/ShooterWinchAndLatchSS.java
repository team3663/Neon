package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;

public class ShooterWinchAndLatchSS extends Subsystem
{
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    public boolean readyToShoot; 
    
    public void initDefaultCommand()
    {
    }
    
    public void WinchAndLatchSS()
    {
        System.out.println("WinchAndLatchSS constructor start");
        winchEncoderReset();
        latchClose();
        setWinchSpeed(0.0);
        System.out.println("WinchAndLatchSS constructor end");
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
        // mustard return -RobotMap.winchEncoder.get();
    }
    
    public void updateStatus()
    {
        if (latchIsOpen())
            SmartDashboard.putString("Latch ","open");
        else
            SmartDashboard.putString("Latch ","closed");
        
        SmartDashboard.putNumber("WinchEncoder:", getWinchEncoder());
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6,1, "Winch: " + (int)getWinchEncoder());
    }
}