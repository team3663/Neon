package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.commands.CommandBase;

public class Photoelectric extends Subsystem
{   
    int counter = 0;
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
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "counter = " + counter++);
    }
}
