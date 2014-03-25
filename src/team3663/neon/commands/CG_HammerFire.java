package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CG_HammerFire extends CommandGroup {
    
    public CG_HammerFire() {
        addSequential(new C_RecordToSmartDashboard("CG_HammerFire", "start"));
        addSequential(new P_FootDown());
        addSequential(new P_HammerExtend());
        addSequential(new C_TimeWait(0.5));
        addSequential(new P_HammerRetract());
        addSequential(new C_RecordToSmartDashboard("CG_HammerFire", "end"));
    }
}
 