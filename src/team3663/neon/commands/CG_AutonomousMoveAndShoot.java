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
public class CG_AutonomousMoveAndShoot extends CommandGroup {
    
    public CG_AutonomousMoveAndShoot() {
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousMoveAndShoot", "start"));
        addSequential(new P_TractionWheelsDown());
        addSequential(new P_FootUp());
        addSequential(new P_ShiftToHighGear());
        addSequential(new C_TimeWait(.5));
        //addSequential(new C_GetValues(1, -.8, 0));
        addSequential(new C_DriveForwardTime(1, -.8, 0));
        addSequential(new C_WindWinch(0));     
        addSequential(new P_ArmDown());   
        addSequential(new P_LatchOpen());
        addSequential(new P_FootDown());
        addParallel(new P_ArmUp());
        addSequential(new P_TractionWheelsUp());
        addSequential(new C_LoosenWinchAndLatch());
        addSequential(new C_WindWinch(0));
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousMoveAndShoot", "end"));
       
    }
}
