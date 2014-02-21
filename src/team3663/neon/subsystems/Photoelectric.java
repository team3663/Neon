package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;

public class Photoelectric extends Subsystem
{   
    public Photoelectric()
    {
        
    }
    public void initDefaultCommand()
    {
        
    }
    public boolean GetSensorStatus(DigitalInput sensor)
    {
        /*This will return either true if a signal is being sent or false if 
          there is no signal*/
        return sensor.get();
    }

    public void UpdateStatus()
    {
	/*SmartDashboard.putBoolean("Ground Sensor: ", GetSensorStatus
        (RobotMap.photoelectricGroundSensor));*/
	DriverStationLCD.getInstance().println
        (DriverStationLCD.Line.kUser3, 1, "PhotoElectric: " + String.valueOf
        (GetSensorStatus(RobotMap.photoelectricGroundSensor)));
	DriverStationLCD.getInstance().updateLCD();
    }
}
