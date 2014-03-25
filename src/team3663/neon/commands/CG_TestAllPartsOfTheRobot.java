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
        
        //loading arm
        addSequential(new P_LoadingArmUp());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new P_LoadingArmDown());
        addSequential(new C_TimeWait(interCommandDelay));
        
        addSequential(new C_SpinLoadingArmMotor(true, 2.0));
        addSequential(new C_TimeWait(interCommandDelay));
        addSequential(new C_SpinLoadingArmMotor(false, 2.0));
        
        addSequential(new P_LoadingArmUp());
        addSequential(new C_TimeWait(interCommandDelay));

        addSequential(new C_DriveMotorTest(1, 2, .5));
        addSequential(new C_DriveMotorTest(2, 2, .5));
        addSequential(new C_DriveMotorTest(3, 2, .5));
        addSequential(new C_DriveMotorTest(4, 2, .5));

}
}
