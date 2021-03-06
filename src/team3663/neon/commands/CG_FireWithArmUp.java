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
public class CG_FireWithArmUp extends CommandGroup {
    
    public CG_FireWithArmUp(double shotStrength) {
        addSequential(new C_RecordToSmartDashboard("CG_FireWithArmUp", "start"));
        addSequential(new C_WindWinch(shotStrength));    
        addSequential(new P_LatchOpen());
        addSequential(new P_FootDown());
        addParallel(new P_ArmUp());
        addSequential(new C_LoosenWinchAndLatch());      
        addSequential(new C_WindWinch(0));
        addSequential(new C_RecordToSmartDashboard("CG_FireWithArmUp", "end"));
    }
}
