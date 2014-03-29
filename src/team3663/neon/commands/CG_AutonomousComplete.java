package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CG_AutonomousComplete extends CommandGroup
{
    public CG_AutonomousComplete()
    {
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousComplete", "start"));
        //addSequential(new C_DriveForwardTime(.1, -.1, 0));
        //addSequential(new CG_AutonomousVisionOnly());
        addSequential(new CG_AutonomousMoveAndShoot());
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousComplete", "end"));
    }
}
