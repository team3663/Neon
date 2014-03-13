package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.commands.CommandBase;

/*
 * @author Kainoa & Tyler
 */

public class AutoTargetAndShootCommand extends CommandBase
{
    
    private boolean isFinished;
    
    public AutoTargetAndShootCommand() 
    { 
        isFinished = false;
    }

    protected void initialize()
    {
        
    }

    protected void execute() 
    { 
        if(Timer.getFPGATimestamp() <= 5 && imageProcess.isHot)
        {
            Shoot();
            isFinished = true;
            System.out.println("Hot Shot");
        }
        if(Timer.getFPGATimestamp() > 5 /*&& shooterSystem.HasBall()*/)
        {
            Shoot();
            System.out.println("Timed Shot");
            isFinished = true;
        }    
        System.out.println("System Time: " + Timer.getFPGATimestamp());
    }

    protected boolean isFinished()
    {
        return isFinished;
    }

    protected void end() {}

    protected void interrupted() {}
    
    public void Shoot()
    {
        /*solenoids.RetractPiston(shooterSystem.shooterSolenoid2, shooterSystem.shooterSolenoid1);
        Timer.delay(0.3);
            
        shooterSystem.SetShooterIsSet(false);
        appendages.SetBallHolderIsStatic(false);
        appendages.RaiseBallHolder(false);*/
    }
}
