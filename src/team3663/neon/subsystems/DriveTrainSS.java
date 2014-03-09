package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.DriveC;

public class DriveTrainSS extends Subsystem
{
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
        return RobotMap.tractionWheelUpDownSolenoid2.get();
    }
    
    public void Arcade(double joyY, double joyZ)
    {
        //find a way to fix this
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        System.out.println("joyY = " + joyY + "\njoyZ = " + joyZ);
        if(joyY < 0.1 && joyY > -0.1)
        {
            joyY = 0;
        }
        RobotMap.driveTrain.arcadeDrive(-joyY, -joyZ);//mustard may be -joyY
        
       
    }
    
     public void Mecanum(double joyX, double joyY, double joyTwist)
    {
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        direction = MathUtils.atan2(joyX, -joyY); // mustard may be joyY
        magnitude = Math.sqrt((joyX * joyX) +  (joyY * joyY));
        if (magnitude < 0.1 && magnitude > -0.1)
        {
            magnitude = 0;
        }
        if (joyTwist < 0.1 && joyTwist > -0.1)
        {
            joyTwist = 0;
        }
        RobotMap.driveTrain.mecanumDrive_Polar(magnitude, Math.toDegrees(direction), joyTwist);
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
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, ("R:" + (int)GetRightEncoder()) + " L:" + (int)GetLeftEncoder());
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
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Up   ");
        }
    }
}
