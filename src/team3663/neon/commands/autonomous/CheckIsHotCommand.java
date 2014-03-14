/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import team3663.neon.commands.CommandBase;

public class CheckIsHotCommand extends CommandBase 
{
    private boolean isFinished;
    private ShooterCommand shootCommand;
    
    public CheckIsHotCommand() 
    {
        isFinished = false;
        shootCommand = new ShooterCommand();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
         if(CommandBase.isHot && !CommandBase.autoIsShot)
        {
            System.out.println("************************It shot***********");
            shootCommand.Shoot();
            CommandBase.autoIsShot = true;
        }
        if(!CommandBase.isHot && (CommandBase.timer.getFPGATimestamp() > 5) && !CommandBase.autoIsShot)
        {
            shootCommand.Shoot();
            System.out.println("isHot false auto");
            CommandBase.autoIsShot = true;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
         if(!shootCommand.isRunning())
         {
             System.out.println("Shooter command stopped running");
             isFinished = true;
         }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
