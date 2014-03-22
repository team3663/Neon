
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author curtis
 */
public class HammerFireAfterDriveForwardCG extends CommandGroup {
    
    public HammerFireAfterDriveForwardCG() {
        addSequential(new DriveForwardTimeC(0.3, -0.5));
        addSequential(new FootDownC());
        addSequential(new HammerExtendC());
        addSequential(new TimeWaitC(0.5));
        addSequential(new HammerRetractC());
    }
}
