package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HammerFireCG extends CommandGroup {
    
    public HammerFireCG() {
        addSequential(new FootDownC());
        addSequential(new HammerExtendC());
        addSequential(new TimeWaitC(0.5));
        addSequential(new HammerRetractC());
    }
}
