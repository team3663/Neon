package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.C_Drive;

public class DriveTrainSS extends Subsystem
{
    public double driveValue;
    public double PI;
    public double ENCODER_CORRECT;
    private double encodeLeftChange;
    private double encodeRightChange;
    public Encoder leftEncoder;
    public Encoder rightEncoder;
    
    private double joyX, joyY, joyZ;
    private double yFlip = 1;
    
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
        driveValue = 1;
        PI = 3.14159;
        ENCODER_CORRECT = PI * 6.25 /** 18.0000 * (5.0000/18.0000) * (1.0000/30.0000) * 6.0000*/;
        leftEncoder = RobotMap.driveTrainLeftEncoder;
        rightEncoder = RobotMap.driveTrainRightEncoder; 
    }
        
    public void initDefaultCommand()
    {
        //might get commented out
       setDefaultCommand(new C_Drive());
    }
      
    public boolean TractionIsDown()
    {
        return RobotMap.tractionWheelUpDownSolenoid1.get();
    }
    
    public void setYDirection(boolean flipYDirection){
        if (flipYDirection)
            yFlip = -1;
        else
            yFlip = 1;
    }
    
    public void drive3663(double jX, double jY, double jZ) 
    {
        final double IDLETOLERANCE = 0.09;
        
        joyX = jX;
        joyY = jY;
        joyZ = jZ;
        jY *= driveValue;
        //jZ *= .75;
        
        if(jX < IDLETOLERANCE && jX > -IDLETOLERANCE)
            jX = 0;

        if(jY < IDLETOLERANCE && jY > -IDLETOLERANCE)
            jY = 0;

        if(jZ < IDLETOLERANCE && jZ > -IDLETOLERANCE)
            jZ = 0;

        // mustard does not flip
        // ketchup
        
        jY = jY*yFlip;
        
        if(TractionIsDown())
        {
            //System.out.println( "ARCADE" + "jY: " + jY + "jZ: " + jZ);
            Arcade(jY, jZ);
        }
        else
        {
            //System.out.println( "MECANUM" + "JX: " + jX + "jY: " + jY + "jZ: " + jZ);
            Mecanum(jX, jY, jZ);
        }
    }
    
    private void Arcade(double joyY, double joyZ)
    {
        RobotMap.driveTrain.arcadeDrive(joyY, -joyZ);
    }
    
    private void Mecanum(double jX, double jY, double jZ)
    {
        double direction = Math.toDegrees(MathUtils.atan2(jX, jY));
        double magnitude = Math.sqrt((jX * jX) +  (jY * jY));
        
        RobotMap.driveTrain.mecanumDrive_Polar(magnitude, direction, jZ);
    }
  
    public boolean InLowGear()
    {
        return RobotMap.gearShiftHighLowSolenoid1.get();
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

        //set for mecanum
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

}
    
    public void TractionWheelsDown()
    {
        RobotMap.tractionWheelUpDownSolenoid1.set(true);
        RobotMap.tractionWheelUpDownSolenoid2.set(false);

        //set for arcade
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    }
    public void changeDriveY()
    {
        driveValue = driveValue * -1;  
    }
    public void updateStatus()
    {
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1,1, ("R:" + (int)GetRightEncoder()) + " L:" + (int)GetLeftEncoder());
        SmartDashboard.putNumber("Left encoder",GetLeftEncoder());
        SmartDashboard.putNumber("Right encoder",GetRightEncoder());
        SmartDashboard.putNumber("Joystick X", joyX);
        SmartDashboard.putNumber("Joystick Y", joyY);
        SmartDashboard.putNumber("Joystick Z", joyZ);
        SmartDashboard.putNumber("DriveMotorLB", RobotMap.driveTrainBackLeftSpeedController.get());
        SmartDashboard.putNumber("DriveMotorRB", RobotMap.driveTrainBackRightSpeedController.get());
        SmartDashboard.putNumber("DriveMotorLF", RobotMap.driveTrainFrontLeftSpeedController.get());
        SmartDashboard.putNumber("DriveMotorRF", RobotMap.driveTrainFrontRightSpeedController.get());

        if (InLowGear())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Low Gear");
            SmartDashboard.putString("Gear","low");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "High Gear");
            SmartDashboard.putString("Gear","high");
        }
        
        if (TractionIsDown())
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Down");
            SmartDashboard.putString("Traction wheels","down");
            SmartDashboard.putString("Driving mode", "arcade");
        }
        else
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "Traction Wheels Up   ");
            SmartDashboard.putString("Traction wheels","up");
            SmartDashboard.putString("Driving mode", "mecanum");
        }
    }
    
}
