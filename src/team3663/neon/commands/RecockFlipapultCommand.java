package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team3663.neon.RobotMap;

public class RecockFlipapultCommand  extends CommandBase 
{
    
    public RecockFlipapultCommand()
    {
        requires(shooterSystem);
    }
    
    protected void initialize()
    {
        while(!RobotMap.ballLimitSwitchDIO.get()){
            shooterSystem.setWinch(1);
        }
        shooterSystem.closeLatch();
        while(shooterSystem.getShooterEncoder() < -40){ //higher number to wind more
            shooterSystem.setWinch(-1);
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
