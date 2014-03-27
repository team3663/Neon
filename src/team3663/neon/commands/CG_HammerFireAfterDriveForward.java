
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
public class CG_HammerFireAfterDriveForward extends CommandGroup {
    
    public CG_HammerFireAfterDriveForward() {
        addSequential(new C_RecordToSmartDashboard("CG_HammerFireAfterDriveForward", "start"));
        addSequential(new C_DriveForwardTime(0.3, -0.5, 0));
        addSequential(new P_FootDown());
        addSequential(new P_HammerExtend());
        addSequential(new C_TimeWait(0.5));
        addSequential(new P_HammerRetract());
        addSequential(new C_RecordToSmartDashboard("CG_HammerFireAfterDriveForward", "end"));
    }
}
