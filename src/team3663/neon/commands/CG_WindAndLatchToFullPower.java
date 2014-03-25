package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CG_WindAndLatchToFullPower extends CommandGroup {
    
    public CG_WindAndLatchToFullPower() {
        addSequential (new C_LoosenWinchAndLatch());
        addSequential (new C_WindWinch(0));
    }
}
