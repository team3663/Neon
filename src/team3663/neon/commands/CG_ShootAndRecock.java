/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author briking
 */
public class CG_ShootAndRecock extends CommandGroup {
    
    public CG_ShootAndRecock(double shotStrength) {
        // Add Commands here:
        //addSequential(new EnableAndDissableButtons(true));
        addSequential(new C_RecordToSmartDashboard("CG_ShootAndRecock", "start"));
        addSequential(new C_WindWinch(shotStrength));     
        addSequential(new P_ArmDown());   
        addSequential(new P_LatchOpen());
        addSequential(new P_FootDown());
        addParallel(new P_ArmUp());
        addSequential(new C_LoosenWinchAndLatch());      
        addSequential(new C_WindWinch(0));
        addSequential(new C_RecordToSmartDashboard("CG_ShootAndRecock", "end"));
    }
}
