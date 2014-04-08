package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.commands.autonomous.TargetCommand;

public class CG_AutonomousVisionOnly extends CommandGroup {
    
    public CG_AutonomousVisionOnly() {
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousVisionOnly", "start"));
        addSequential(new C_CameraDetectHotGoal());
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousVisionOnly", "end"));

    }
}
