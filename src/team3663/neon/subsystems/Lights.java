package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem 
{
    public void initDefaultCommand()
    {
        
    }
    
    public void TurnOnRelay(Relay relay)
    {
       relay.set(Relay.Value.kForward);
    }
    
    public void TurnOffRelay(Relay relay)
    {
        relay.set(Relay.Value.kOff);
    }
}
