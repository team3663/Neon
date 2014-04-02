package team3663.neon.commands;

public class C_FillAirTanks extends CommandBase
{
    public C_FillAirTanks()
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