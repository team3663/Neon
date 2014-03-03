package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.FillAirTanksCommand;

public class Compressor extends Subsystem 
{
    //public Relay compressorSwitch;
    //public DigitalInput compressorLimitSwitch;
    int ccc;
    public void Compressor()
    {
        //RobotMap.compressorOnOffRelay.setDirection(Relay.Direction.kForward);
        //RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);
        ccc=0;
    }
    public void initDefaultCommand() 
    {
        setDefaultCommand(new FillAirTanksCommand());
    }
    public void TurnOn()
    {
        RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);//Mustard may be kReverse
    }
    public void TurnOff()
    {
        RobotMap.compressorOnOffRelay.set(Relay.Value.kOff);
    }
    public boolean airTanksAreFull()
    {
        return RobotMap.compressorLimitSwitchDIO.get();//Mustard may be opposite
    }
    public void UpdateStatus()
    {
        //    RobotMap.compressorOnOffRelay.set(Relay.Value.kForward);
//        if (RobotMap.compressorOnOffRelay.get() == Relay.Value.kOff)
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Compressor: "+ ccc++);
//        else
//            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Compressor on");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6, 1, "Air tanks full=" + airTanksAreFull());
        //SmartDashboard.putBoolean("Compressor State", compressorSwitch.get() == Relay.Value.kOn);
    }
}

