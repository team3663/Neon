package team3663.neon.commands;

public class FillAirTanksC extends CommandBase
{
    public FillAirTanksC()
    {
        requires(compressorSS);
    }
    
    protected void initialize(){
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
        return false;
    }
    
    protected void end(){
    }
    
    protected void interrupted(){
    }
}