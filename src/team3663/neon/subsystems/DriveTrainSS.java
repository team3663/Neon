package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.Robot3663;
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
        System.out.println("DriveTrainSS constructor start");
        Stop();
        ShiftToLowGear();
        TractionWheelsDown();
        System.out.println("DriveTrainSS constructor end");
    }
        
    public void initDefaultCommand()
    {
       setDefaultCommand(new DriveC());
    }
      
    public boolean TractionIsDown()
    {
        return RobotMap.tractionWheelUpDownSolenoid1.get();
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
        if(Robot3663.mustard)
        {
            RobotMap.driveTrain.arcadeDrive(-joyY, -joyZ);
        }
        else
        {
            RobotMap.driveTrain.arcadeDrive(-joyY, -joyZ);
        }
        
        
       
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
  
    public void ShiftToHighGear(){//black slider of transmissions out
        RobotMap.gearShiftHighLowSolenoid1.set(false);
        RobotMap.gearShiftHighLowSolenoid2.set(true);
    }
    
   public void ShiftToLowGear(){//black slider of transmissions in
        RobotMap.gearShiftHighLowSolenoid1.set(true);
        RobotMap.gearShiftHighLowSolenoid2.set(false);
    }
    public void TestMotors(int motorNumber, double speed)
    {
        if(motorNumber == 1)
        {
            RobotMap.driveTrainBackLeftSpeedController.set(speed);
        }
        if(motorNumber == 2)
        {
            RobotMap.driveTrainFrontLeftSpeedController.set(speed);
        }
        if(motorNumber == 3)
        {
            RobotMap.driveTrainFrontRightSpeedController.set(speed);
        }
        if(motorNumber == 4)
        {
            RobotMap.driveTrainBackRightSpeedController.set(speed);
        }
        if(motorNumber == 5)
        {
            RobotMap.LoadingArmSpeedController.set(speed);
        }
    }
    public void Drive(double speed, double curve)
    {
        RobotMap.driveTrain.arcadeDrive(speed, curve);
    }
    public void Stop()
    {
        Drive(0, 0);
    }
    public boolean InLowGear()
    {
        return RobotMap.gearShiftHighLowSolenoid2.get();
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
    
    public void updateStatus()
    {
    //    SmartDashboard.putNumber("Right Encoder:", GetRightEncoder());
//	SmartDashboard.putNumber("Left Encoder:", GetLeftEncoder());
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, ("R:" + (int)GetRightEncoder()) + " L:" + (int)GetLeftEncoder());
	if (InLowGear())
        {
		CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Low Gear");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "High Gear");
        }
        
        if (TractionIsDown())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Down");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Up   ");
        }
    }
}
