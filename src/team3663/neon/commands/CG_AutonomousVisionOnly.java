package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.autonomous.CheckIsHotCommand;
import team3663.neon.commands.autonomous.TargetCommand;

public class CG_AutonomousVisionOnly extends CommandGroup {
    
    public CG_AutonomousVisionOnly() {
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousVisionOnly", "start"));
        addSequential(new TargetCommand());
        //addSequential(new CheckIsHotCommand());
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousVisionOnly", "end"));

    }
}
