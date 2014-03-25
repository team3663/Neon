package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.C_FillAirTanks;

public class CompressorSS extends Subsystem 
{
    boolean compressorOn;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new C_FillAirTanks());
    }

    public void CompressorSS()
    {
        System.out.println("CompressorSS constructor start");
        TurnOff();
        System.out.println("CompressorSS constructor end");
    }
    
    public void TurnOn()
    {
        compressorOn = true;
        RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);
    }
    
    public void TurnOff()
    {
        compressorOn = false;
        RobotMap.compressorOnOffRelay.set(Relay.Value.kOff);
    }
    
    public boolean airTanksAreFull()
    {
        return RobotMap.compressorLimitSwitchDIO.get();
    }
    
    public void updateStatus()
    {
        if(airTanksAreFull()){
            SmartDashboard.putString("Air tanks ", "full");
        }
        else
        {
            SmartDashboard.putString("Air tanks ", "not full");
        }
        if(compressorOn)
        {
            SmartDashboard.putString("Compressor ", "on");
        }
        else
        {
            SmartDashboard.putString("Compressor ", "off");
        }
    }
}

