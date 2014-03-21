package team3663.neon.commands;

public class HammerRetractC extends CommandBase
{
    public HammerRetractC()
    {
        requires(hammerSS);
    }
    
    protected void initialize(){
    }
    
    protected void execute()
    {
        hammerSS.hammerRetract();
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
    }
}
