package team3663.neon.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;
import team3663.neon.commands.DriveCommand;

public class DriveTrain extends Subsystem
{
    
    public double ACCEL_LIMIT = 0.2;
    public double DECEL_LIMIT = 0.2;
    public double PI = 3.14159;
    public double ENCODER_CORRECT  = 4 * 12 / 22 / 1440 * 5 / 3;
    
    public boolean highGear;
    private double direction;
    private double magnitude;
    public void Init()
    {

        highGear = true;
        ShiftToLowGear();
        TractionWheelsDown();
    }
        
    public void initDefaultCommand()
    {
       setDefaultCommand(new DriveCommand());
    }
      
    public boolean IsTractionDown()
    {
        return RobotMap.driveTrainDriveChange1.get();
    }
    
    public void Arcade(double joyX, double joyY, double joyZ)
    {
        RobotMap.driveTrainRobotDrive3663.arcadeDrive(joyX, -joyY);
    }
    
     public void Mechanum(double joyX, double joyY, double joyTwist)
    {
        direction = MathUtils.atan2(-joyX, joyY);
        magnitude = Math.sqrt((joyX * joyX) +  (joyY * joyY));
        
        RobotMap.driveTrainRobotDrive3663.mecanumDrive_Polar(magnitude, Math.toDegrees(direction), joyTwist/2);
    }
  
    public void ShiftToHighGear(){
        RobotMap.driveTrainGearShift1.set(false);
        RobotMap.driveTrainGearShift2.set(true);
    }
    
   public void ShiftToLowGear(){
        RobotMap.driveTrainGearShift1.set(true);
        RobotMap.driveTrainGearShift2.set(false);
    }
    
    public void Drive(double speed, double curve)
    {
        RobotMap.driveTrainRobotDrive3663.arcadeDrive(speed, curve);
    }
    public void Stop()
    {
        Drive(0, 0);
    }
    public boolean IsHighGear()
    {
        return RobotMap.driveTrainGearShift1.get();
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
        RobotMap.driveTrainDriveChange1.set(false);
        RobotMap.driveTrainDriveChange2.set(true);
    }
    
    public void TractionWheelsDown()
    {
        RobotMap.driveTrainDriveChange1.set(true);
        RobotMap.driveTrainDriveChange2.set(false);
    }
    
    /*public void UpdateStatus()
    {
        SmartDashboard.putNumber("Right Encoder:", GetRightEncoder());
	SmartDashboard.putNumber("Left Encoder:", GetLeftEncoder());
	if (highGear)
		SmartDashboard.putString("Transmission:", "High Gear");
	else
		SmartDashboard.putString("Transmission:", "Low Gear");
    }*/

}
