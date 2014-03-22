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
public class AutonomousBackUpCG extends CommandGroup {
    
    public AutonomousBackUpCG() {
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
        //addParallel(new ResetTheFireButtonsC());
        addSequential(new WindWinchC(0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
