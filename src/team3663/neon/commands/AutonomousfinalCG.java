package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.autonomous.CheckIsHotCommand;
import team3663.neon.commands.autonomous.TargetCommand;

public class AutonomousfinalCG extends CommandGroup
{
    public AutonomousfinalCG()
    {
        addSequential(new TargetCommand());
        addSequential(new CheckIsHotCommand());
        addSequential(new TractionWheelsDownC());
        addSequential(new FootUpC());
        addSequential(new ShiftToHighGearC());
        addSequential(new TimeWaitC(.5));
        addSequential(new DriveForwardTimeC(.7, -1));
        addSequential(new WindWinchC(0));     
        addSequential(new LoadingArmDownC());   
        addSequential(new LatchOpenC());
        addSequential(new FootDownC());
        addParallel(new LoadingArmUpC());
        addSequential(new TractionWheelsUpC());
        addSequential(new LoosenWinchAndLatchC());
        addSequential(new WindWinchC(0));
    }
}
