package team3663.neon.commands;

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
/*        
        if (compressor.compressorLimitSwitch.get() == false)
        {
		compressor.TurnOn();
	}
	else
        {
		compressor.TurnOff();
	}
*/        
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
