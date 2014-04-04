package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CG_TractionWheelsDownLowGear extends CommandGroup {
    
    public CG_TractionWheelsDownLowGear() {
        addSequential(new C_RecordToSmartDashboard("CG_TractionWheelsDownLowGear", "start"));
        addSequential(new P_TractionWheelsDown(false));
        addSequential(new P_ShiftToLowGear());
        addSequential(new C_RecordToSmartDashboard("CG_TractionWheelsDownLowGear", "end"));
    }
}
