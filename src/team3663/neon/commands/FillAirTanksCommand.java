package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FillAirTanksCommand extends CommandBase
{
    public FillAirTanksCommand()
    {
        requires(compressor);
    }
    protected void initialize()
    {

    }
    protected void execute()
    {        
        if (compressor.airTanksAreFull())
        {
            SmartDashboard.putString("Compressor:", "Off");
            compressor.TurnOff();
	}
	else
        {
            SmartDashboard.putString("Compressor:", "On");
            compressor.TurnOn();
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
