package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CG_TractionWheelsUpHighGear extends CommandGroup {
    
    public CG_TractionWheelsUpHighGear() {
        addSequential(new C_RecordToSmartDashboard("CG_TractionWheelsUpHighGear", "start"));
        addSequential(new P_TractionWheelsUp());
        addSequential(new P_ShiftToHighGear()); 
        addSequential(new C_RecordToSmartDashboard("CG_TractionWheelsUpHighGear", "end"));
    }
}
