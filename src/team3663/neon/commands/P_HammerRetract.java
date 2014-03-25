package team3663.neon.commands;

public class P_HammerRetract extends CommandBase
{
    public P_HammerRetract()
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
