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
public class ShootAndRecockCG extends CommandGroup {
    
    public ShootAndRecockCG(double shotStrength) {
        // Add Commands here:
        
        addParallel(new WindWinchC(shotStrength));
        addSequential(new LoadingArmDownC());
        addSequential(new ShooterLatchOpenC());
        addParallel(new LoadingArmUpC());
        addSequential(new LoosenWinchAndLatchC());
        addSequential(new WindWinchC(0));
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
