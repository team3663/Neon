package team3663.neon.commands;

import edu.wpi.first.wpilibj.Solenoid;
import team3663.neon.RobotMap;

public class CommandsGlobalVars 
{
    public boolean pickUpState;
    public boolean shooterIsSet;
    public double encodeCount;
    public double ENCODE_LIMIT;
    public Solenoid pickUpSolenoid1 = RobotMap.pickUpSolenoid1;
    public Solenoid pickUpSolenoid2 = RobotMap.pickUpSolenoid2;
    public Solenoid ejectSolenoid1 = RobotMap.hammerSolenoid1;
    public Solenoid ejectSolenoid2 = RobotMap.hammerSolenoid2;
    
    public void Init()
    {
        pickUpState = false;
        shooterIsSet = true;
        pickUpSolenoid1.set(false);
        pickUpSolenoid2.set(true);
        
        ejectSolenoid1.set(false);
        ejectSolenoid2.set(true);
        
        encodeCount = 0;
        ENCODE_LIMIT = 0;//-350
    }
}
