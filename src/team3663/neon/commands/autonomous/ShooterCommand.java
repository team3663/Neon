package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.FootDownC;
import team3663.neon.commands.LoadingArmDownC;
import team3663.neon.commands.LoadingArmUpC;
import team3663.neon.commands.LoosenWinchAndLatchC;
import team3663.neon.commands.ShooterLatchOpenC;
import team3663.neon.commands.TractionWheelsUpC;
import team3663.neon.commands.WindWinchC;

/*
 * @author Kainoa & Tyler
 */
public class ShooterCommand extends CommandGroup
{
    public ShooterCommand()
    {
        
    }
    public void Shoot()
    {
        System.out.println("************************It shot in shooter command***********");
        addSequential(new WindWinchC(0));       
        addSequential(new ShooterLatchOpenC());
        addSequential(new FootDownC());
        addParallel(new LoadingArmUpC());
        addSequential(new TractionWheelsUpC());
        addSequential(new LoosenWinchAndLatchC());
        //addParallel(new ResetTheFireButtonsC());
        addSequential(new WindWinchC(0));
        // Add Commands here:
    }
}
