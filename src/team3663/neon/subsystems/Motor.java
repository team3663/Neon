package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Motor extends Subsystem
{
    
    //Test and see if we can make one total motorSpeed var
    
    protected void initDefaultCommand() 
    {
       
    }
    
    public void SetMotorSpeed(Victor motor, double speed)
    {
        motor.set(speed);
    }
    
    public void SetMotorSpeed(SpeedController motor, double speed)
    {
        motor.set(speed);
    }
    
    public double GetMotorSpeed(Victor motor)
    {
        return motor.getSpeed();
    }
}