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
public class CG_TestAllPartsOfTheRobot extends CommandGroup {
    
    public CG_TestAllPartsOfTheRobot() {
        addSequential(new C_RecordToSmartDashboard("CG_TestAllPartsOfTheRobot", "start"));
        
        double interCommandDelay = .25;
        
        //compressor
        addSequential(new C_WaitForCompressor());
        
        //winch and latch
        addSequential(new C_WindWinch(400));
        
        addSequential(new P_LatchClose());
        
        addSequential(new P_LatchOpen());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_LatchClose());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new C_WindWinch(0));  
        
        //traction wheels
        addSequential(new P_TractionWheelsDown());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_TractionWheelsUp());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_TractionWheelsDown());
        
        //gear shifting
        addSequential(new P_ShiftToHighGear());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_ShiftToLowGear());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_ShiftToHighGear());
        
        //hammer
        addSequential(new P_HammerRetract());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_HammerExtend());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_HammerRetract());

        //foot
        addSequential(new P_FootUp());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_FootDown());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_FootUp());
        
        //arm
        addSequential(new P_ArmUp());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_ArmDown());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_SpinArmMotor(true, 2.0));
        addSequential(new C_TimeWait(interCommandDelay));
        addSequential(new P_SpinArmMotor(false, 2.0));
        
        addSequential(new P_ArmUp());
        addSequential(new C_TimeWait(interCommandDelay));

        addSequential(new C_DriveMotorTest(1, 2, .5));
        addSequential(new C_DriveMotorTest(2, 2, .5));
        addSequential(new C_DriveMotorTest(3, 2, .5));
        addSequential(new C_DriveMotorTest(4, 2, .5));
        addSequential(new C_RecordToSmartDashboard("CG_TestAllPartsOfTheRobot", "end"));

}
}
