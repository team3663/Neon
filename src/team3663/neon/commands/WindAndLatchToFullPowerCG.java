package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class WindAndLatchToFullPowerCG extends CommandGroup {
    
    public WindAndLatchToFullPowerCG() {
        addSequential (new LoosenWinchAndLatchC());
        addSequential (new WindWinchC(0));
    }
}
