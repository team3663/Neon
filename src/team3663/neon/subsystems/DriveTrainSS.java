package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.DriveC;

public class DriveTrainSS extends Subsystem
{
    
    public double ACCEL_LIMIT = 0.2;
    public double DECEL_LIMIT = 0.2;
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    
    public boolean highGear;
    private double direction;
    private double magnitude;
    
    public void DriveTrainSS()
    {
        ShiftToLowGear();
        TractionWheelsDown();
    }
        
    public void initDefaultCommand()
    {
       setDefaultCommand(new DriveC());
    }
      
    public boolean IsTractionDown()
    {
        return RobotMap.tractionWheelUpDownSolenoid1.get();
    }
    
    public void Arcade(double joyX, double joyY, double joyZ)
    {
        RobotMap.driveTrain.arcadeDrive(joyX, -joyY);
    }
    
     public void Mecanum(double joyX, double joyY, double joyTwist)
    {
        direction = MathUtils.atan2(-joyX, joyY);
        magnitude = Math.sqrt((joyX * joyX) +  (joyY * joyY));
        
        RobotMap.driveTrain.mecanumDrive_Polar(magnitude, Math.toDegrees(direction), joyTwist/2);
    }
  
    public void ShiftToHighGear(){
        RobotMap.gearShiftHighLowSolenoid1.set(false);
        RobotMap.gearShiftHighLowSolenoid2.set(true);
    }
    
   public void ShiftToLowGear(){
        RobotMap.gearShiftHighLowSolenoid1.set(true);
        RobotMap.gearShiftHighLowSolenoid2.set(false);
    }
    
    public void Drive(double speed, double curve)
    {
        RobotMap.driveTrain.arcadeDrive(speed, curve);
    }
    public void Stop()
    {
        Drive(0, 0);
    }
    public boolean IsLowGear()
    {
        return RobotMap.gearShiftHighLowSolenoid1.get();
    }
    public double GetLeftEncoder()
    {
        return RobotMap.driveTrainLeftEncoder.getRaw();
    }
    public double GetRightEncoder()
    {
        return RobotMap.driveTrainRightEncoder.getRaw();
    }
    public void ResetDriveEncoders()
    {
        RobotMap.driveTrainRightEncoder.reset();
        RobotMap.driveTrainLeftEncoder.reset();
    }
    
    public void TractionWheelsUp()
    {
        RobotMap.tractionWheelUpDownSolenoid1.set(false);
        RobotMap.tractionWheelUpDownSolenoid2.set(true);
    }
    
    public void TractionWheelsDown()
    {
        RobotMap.tractionWheelUpDownSolenoid1.set(true);
        RobotMap.tractionWheelUpDownSolenoid2.set(false);
    }
    
    public void UpdateStatus()
    {
    //    SmartDashboard.putNumber("Right Encoder:", GetRightEncoder());
//	SmartDashboard.putNumber("Left Encoder:", GetLeftEncoder());
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, ("(" + (int)GetRightEncoder()) + "," + (int)GetLeftEncoder() + ")");
	if (IsLowGear())
        {
		CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Low Gear");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "High Gear");
        }
        
        if (IsTractionDown())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Down");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Up");
        }
    }
}