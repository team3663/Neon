package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.DriveC;

public class DriveTrainSS extends Subsystem
{
    public boolean highGear;
    private double direction;
    private double magnitude;
    
    public double PI;
    public double ENCODER_CORRECT;
    private double encodeRightPrevious;
    private double encodeLeftPrevious;
    private double encodeLeftChange;
    private double encodeRightChange;
    public Encoder leftEncoder;
    public Encoder rightEncoder;
    
    public void DriveTrainSS()
    {
        System.out.println("DriveTrainSS constructor start");
        ShiftToLowGear();
        TractionWheelsDown();
        Arcade(0,0);
        System.out.println("DriveTrainSS constructor end");
    }
    
    public void Init()
    {
        PI = 3.14159;
        ENCODER_CORRECT = PI * 6.25 /** 18.0000 * (5.0000/18.0000) * (1.0000/30.0000) * 6.0000*/;
        leftEncoder = RobotMap.driveTrainLeftEncoder;
        rightEncoder = RobotMap.driveTrainRightEncoder; 
    }
        
    public void initDefaultCommand()
    {
       setDefaultCommand(new DriveC());
    }
      
    public boolean TractionIsDown()
    {
        return RobotMap.tractionWheelUpDownSolenoid1.get();
    }
    
    // should switch DriveC to use this when it can be tested
    /*
    public void drive3663(double jX, double jY, double jZ) 
    {
       if(TractionIsDown())
       {
           Arcade(jY, jZ);
           SmartDashboard.putString("Driving:", "Arcade");
       }
       else
       {
           Mecanum(jX, jY, jZ);
           SmartDashboard.putString("Driving:", "Mecanum");
       }
    }
*/
    
    public void Arcade(double joyY, double joyZ)
    {
        //todo: add logic so invert does not need to be called every time
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);

        //stop motor hum when idle
        if(joyY < 0.1 && joyY > -0.1)
        {
            joyY = 0;
        }

        RobotMap.driveTrain.arcadeDrive(joyY, -joyZ);
    }
    
     public void Mecanum(double joyX, double joyY, double joyTwist)
    {
        //todo: add logic so invert does not need to be called every time
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

        direction = MathUtils.atan2(joyX, joyY);
        magnitude = Math.sqrt((joyX * joyX) +  (joyY * joyY));
        
        if (magnitude < 0.1 && magnitude > -0.1)
        {
            magnitude = 0;
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
   
    public void driveBackLeftSpeedController(double speed)
    {
        RobotMap.driveTrainBackLeftSpeedController.set(speed);
    }

    public void driveFrontLeftSpeedController(double speed)
    {
        RobotMap.driveTrainFrontLeftSpeedController.set(speed);
    }

    public void driveFrontRightSpeedController(double speed)
    {
        RobotMap.driveTrainFrontRightSpeedController.set(speed);
    }

    public void driveBackRightSpeedController(double speed)
    {
        RobotMap.driveTrainBackRightSpeedController.set(speed);
    }
    
    public boolean InLowGear()
    {
        return RobotMap.gearShiftHighLowSolenoid2.get();
    }
    public double GetLeftEncoder()
    {
        return -RobotMap.driveTrainLeftEncoder.getRaw();
    }
    public double GetRightEncoder()
    {
        return -RobotMap.driveTrainRightEncoder.getRaw();
    }
    public void ResetDriveEncoders()
    {
        RobotMap.driveTrainRightEncoder.reset();
        RobotMap.driveTrainLeftEncoder.reset();
    }
    
    public double GetLeftDistance()
    {
        encodeLeftChange = ((leftEncoder.getRaw() / 360.0000)/ ENCODER_CORRECT);
        return -1 * encodeLeftChange;
    }
    public double GetRightDistance()
    {
        encodeRightChange = ((rightEncoder.getRaw() / 360.0000 ) / ENCODER_CORRECT);
        return -1 * encodeRightChange;
    }
    
    public double EncoderError()
    {
        double avg = ((GetRightDistance() +  GetLeftDistance())) / 10;
        System.out.println("% Difference: "+avg);
        if(avg > 0.3)
        {
            avg = 0.3;
        }
        return avg;
    }
    
    public double GetTotalDistance()
    {
        double avgDistance = ((rightEncoder.getRaw() +  (leftEncoder.getRaw())) / 2.0000);
        System.out.println("GetTotalDistance()");
        
        return -1 * ((avgDistance/360.0000) / ENCODER_CORRECT);// 5.5, 8, 9.3
    }
    
    public void DriveEncoderReset()
    {
        rightEncoder.reset();
        leftEncoder.reset();
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
        SmartDashboard.putNumber("LeftEncoder",GetLeftEncoder());
        SmartDashboard.putNumber("RightEncoder",GetRightEncoder());
	
	
       // System.out.println("Ecnoder fr DriveTrain:"+GetTotalDistance());
        //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, ("R:" + (int)GetRightEncoder()) + " L:" + (int)GetLeftEncoder());
        if (InLowGear())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Low Gear");
            SmartDashboard.putString("Gear","Low");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "High Gear");
            SmartDashboard.putString("Gear","High");
        }
        
        if (TractionIsDown())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Down");
            SmartDashboard.putString("Traction Wheels","Down");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Up   ");
            SmartDashboard.putString("Traction Wheels","Up");
        }
    }
}
