package team3663.neon.commands;

public class TogglePickUpArmCommand extends CommandBase
{
    public TogglePickUpArmCommand()
    {
        requires(ballHandler);
    }
    protected void initialize()
    {
        if(ballHandler.IsLoadingArmUp()){
            ballHandler.LoadingArmDown();
            ballHandler.LoadingArmMotorIntake();
        }
        else{
            ballHandler.LoadingArmUp();
            ballHandler.LoadingArmMotorStop();
        }
    }
    protected void execute()
    {
        
        
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
