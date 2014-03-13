package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.autonomous.CheckIsHotCommand;
import team3663.neon.commands.autonomous.EncoderDrive;
import team3663.neon.commands.autonomous.ShooterCommand;
import team3663.neon.commands.autonomous.TargetCommand;

/*
 * @author Kainoa & Tyler
 */
public class AutonomousCG extends CommandGroup
{
    
    public AutonomousCG()
    {
        addSequential(new EncoderDrive(10, -0.8));
        addSequential(new TargetCommand());
        addSequential(new CheckIsHotCommand());
        System.out.println("Autonomous isHot: "+CommandBase.isHot);
        /*while(Timer.getFPGATimestamp() < 10)
        {
            if(CommandBase.isHot)
            {
                System.out.println("isHot true auto");
                addSequential(new ShooterCommand());
            }
            else
            {
                System.out.println("isHot false auto");
            }
        }*/
    }
}
