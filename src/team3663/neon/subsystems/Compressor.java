package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.FillAirTanksCommand;

public class Compressor extends Subsystem 
{
    public Relay compressorSwitch;
    public DigitalInput compressorLimitSwitch;
    
    public void Compressor()
    {
        compressorLimitSwitch = RobotMap.pneumaticsCompressorLimitSwitch;
        compressorSwitch = RobotMap.pneumaticsCompressorSwitch;
        compressorSwitch.set(Relay.Value.kReverse);
    }
    public void initDefaultCommand() 
    {
        setDefaultCommand(new FillAirTanksCommand());
    }
    
    /** 
     *Turns Compressor On
     */
    public void TurnOn()
    {
        compressorSwitch.set(Relay.Value.kReverse);
    }
    public void TurnOff()
    {
        compressorSwitch.set(Relay.Value.kOff);
    }
    /*public void UpdateSatus()
    {
        SmartDashboard.putBoolean("Compressor State", compressorSwitch.get() == Relay.Value.kOn);
    }*/
}

