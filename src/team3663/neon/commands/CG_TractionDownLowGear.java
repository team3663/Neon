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
public class CG_TractionDownLowGear extends CommandGroup {
    
    public CG_TractionDownLowGear() {
         addSequential(new P_TractionWheelsDown());
         addSequential(new P_ShiftToLowGear());
     }
}
