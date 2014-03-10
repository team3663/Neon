package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FillAirTanksC extends CommandBase
{
    public FillAirTanksC()
    {
        requires(compressorSS);
    }
    protected void initialize()
    {

    }
    protected void execute()
    {        
        if (compressorSS.airTanksAreFull())
        {
            compressorSS.TurnOff();
	}
	else
        {
            compressorSS.TurnOn();
	}
    }
    protected boolean isFinished()
    {
        return true;
    }
    protected void end()
    {

    }
    protected void interrupted()
    {
        end();
    }
}
