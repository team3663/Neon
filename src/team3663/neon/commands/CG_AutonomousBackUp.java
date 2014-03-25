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
public class CG_AutonomousBackUp extends CommandGroup {
    
    public CG_AutonomousBackUp() {
        addSequential(new C_RecordToSmartDashboard("CG_AutonomousBackUp", "start"));
        addSequential(new P_TractionWheelsDown());
        addSequential(new P_FootUp());
        addSequential(new P_ShiftToHighGear());
        addSequential(new C_TimeWait(.5));
        addSequential(new C_DriveForwardTime(1, -.8));
        addSequential(new C_WindWinch(0));     
        addSequential(new P_LoadingArmDown());   
        addSequential(new P_LatchOpen());
        addSequential(new P_FootDown());
        addParallel(new P_LoadingArmUp());
        addSequential(new P_TractionWheelsUp());
        addSequential(new C_LoosenWinchAndLatch());
        //addParallel(new ResetTheFireButtonsC());
        addSequential(new C_WindWinch(0));
        addSequential(new C_RecordToSmartDashboard("CG_Autonomous2", "end"));
       
    }
}
