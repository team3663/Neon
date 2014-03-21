package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.FootDownC;
import team3663.neon.commands.LoadingArmDownC;
import team3663.neon.commands.LoadingArmUpC;
import team3663.neon.commands.LoosenWinchAndLatchC;
import team3663.neon.commands.LatchOpenC;
import team3663.neon.commands.TractionWheelsUpC;
import team3663.neon.commands.WindWinchC;

/*
 * @author Kainoa & Tyler
 */
public class ShooterCommand extends CommandGroup
{
    public ShooterCommand()
    {     System.out.println("************************It shot in shooter command***********");
        addSequential(new WindWinchC(0));       
        System.out.println("wind winch");
        addSequential(new LatchOpenC());
        Timer.delay(0.5);
        System.out.println("shoot latch");
        addSequential(new FootDownC());
        System.out.println("foot down");
        addParallel(new LoadingArmUpC());
        System.out.println("loading arm");
        addSequential(new TractionWheelsUpC());
        System.out.println("traction wheels");
        addSequential(new LoosenWinchAndLatchC());
        System.out.println("loosen winch");
        //addParallel(new ResetTheFireButtonsC());
        addSequential(new WindWinchC(0));
        System.out.println("wind winch");
    }
    public void Shoot()
    {
   
// Add Commands here:
    }
}
