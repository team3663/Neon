package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.autonomous.CheckIsHotCommand;
import team3663.neon.commands.autonomous.TargetCommand;

public class CG_Autonomousfinal extends CommandGroup
{
    public CG_Autonomousfinal()
    {
        addSequential(new C_RecordToSmartDashboard("CG_Autonomousfinal", "start"));
        addSequential(new TargetCommand());
        addSequential(new CheckIsHotCommand());
        addSequential(new P_TractionWheelsDown());
        addSequential(new P_FootUp());
        addSequential(new P_ShiftToHighGear());
        addSequential(new C_TimeWait(.5));
        addSequential(new C_DriveForwardTime(1, -.8));
        addSequential(new C_WindWinch(0));     
        addSequential(new P_LoadingArmDown());   
        addSequential(new P_LatchOpen());
        addSequential(new P_FootDown());
        addParallel(new P_LoadingArmUp());
        addSequential(new P_TractionWheelsUp());
        addSequential(new C_LoosenWinchAndLatch());
        addSequential(new C_WindWinch(0));
        addSequential(new C_RecordToSmartDashboard("CG_Autonomousfinal", "end"));
    }
}
