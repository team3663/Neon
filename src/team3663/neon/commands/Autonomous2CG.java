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
public class Autonomous2CG extends CommandGroup {
    
    public Autonomous2CG() {
        addSequential(new TimeWaitIfColdC());
        addSequential(new TractionWheelsDownC());
        addSequential(new FootUpC());
        addSequential(new ShiftToHighGearC());
        addSequential(new TimeWaitC(.5));
        addSequential(new DriveForwardTimeC(.7, -1));
        addSequential(new WindWinchC(0));     
        addSequential(new LoadingArmDownC());   
        addSequential(new LatchOpenC());
        addSequential(new FootDownC());
        addParallel(new LoadingArmUpC());
        addSequential(new TractionWheelsUpC());
        addSequential(new LoosenWinchAndLatchC());
        addSequential(new WindWinchC(0));
    }
}
