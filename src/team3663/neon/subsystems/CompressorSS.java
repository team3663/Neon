package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.FillAirTanksC;

public class CompressorSS extends Subsystem 
{
    boolean compressorOn;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new FillAirTanksC());
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
        RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);//Mustard may be kReverse
    }
    
    public void TurnOff()
    {
        compressorOn = false;
        RobotMap.compressorOnOffRelay.set(Relay.Value.kOff);
    }
    
    public boolean airTanksAreFull()
    {
        return RobotMap.compressorLimitSwitchDIO.get();//Mustard may be opposite
    }
    
    public void updateStatus()
    {
        if(airTanksAreFull()){
            SmartDashboard.putString("Air Tanks: ", "Full");
        }
        else
        {
            SmartDashboard.putString("Air Tanks:", "Not full");
        }
        if(compressorOn)
        {
            SmartDashboard.putString("Compressor: ", "ON");
        }
        else
        {
            SmartDashboard.putString("Compressor: ", "OFF");
        }
    }
}

