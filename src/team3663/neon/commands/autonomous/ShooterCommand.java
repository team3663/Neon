package team3663.neon.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.P_FootDown;
import team3663.neon.commands.P_ArmDown;
import team3663.neon.commands.P_ArmUp;
import team3663.neon.commands.C_LoosenWinchAndLatch;
import team3663.neon.commands.P_LatchOpen;
import team3663.neon.commands.P_TractionWheelsUp;
import team3663.neon.commands.C_WindWinch;

/*
 * @author Kainoa & Tyler
 */
public class ShooterCommand extends CommandGroup
{
    public ShooterCommand()
    {     System.out.println("************************It shot in shooter command***********");
        addSequential(new C_WindWinch(0));       
        System.out.println("wind winch");
        addSequential(new P_LatchOpen());
        Timer.delay(0.5);
        System.out.println("shoot latch");
        addSequential(new P_FootDown());
        System.out.println("foot down");
        addParallel(new P_ArmUp());
        System.out.println("arm up");
        addSequential(new P_TractionWheelsUp());
        System.out.println("traction wheels");
        addSequential(new C_LoosenWinchAndLatch());
        System.out.println("loosen winch");
        //addParallel(new ResetTheFireButtonsC());
        addSequential(new C_WindWinch(0));
        System.out.println("wind winch");
    }
    public void Shoot()
    {
   
// Add Commands here:
    }
}
