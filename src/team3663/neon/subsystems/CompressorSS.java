package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.FillAirTanksC;

public class CompressorSS extends Subsystem 
{
    boolean compressorOn;
    int counter = 0;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new FillAirTanksC());
    }

    public void Compressor()
    {
        TurnOff();
    }
    
    public void TurnOn()
    {
        counter++;
        compressorOn = true;
        RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);//Mustard may be kReverse
    }
    
    public void TurnOff()
    {
        counter--;
        compressorOn = false;
        RobotMap.compressorOnOffRelay.set(Relay.Value.kOff);
    }
    
    public boolean airTanksAreFull()
    {
        return RobotMap.compressorLimitSwitchDIO.get();//Mustard may be opposite
    }
    
    public void UpdateStatus()
    {
        //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Compressor on="+compressorOn);
        //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6, 1, "Air " + airTanksAreFull()+ " " + counter);
        //SmartDashboard.putBoolean("Compressor State", compressorSwitch.get() == Relay.Value.kOn);
    }
}

