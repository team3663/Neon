package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_FillAirTanks extends CommandBase
{
    public C_FillAirTanks()
    {
        requires(compressorSS);
    }
    
    protected void initialize(){
        SmartDashboard.putString("C_FillAirTanks", "initialize");        
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
        SmartDashboard.putString("C_FillAirTanks", "end");        
    }
    
    protected void interrupted(){
        SmartDashboard.putString("C_FillAirTanks", "interrupted");        
    }
}