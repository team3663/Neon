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
public class AutonomousCG extends CommandGroup {
    
    public AutonomousCG() {
        addSequential(new DriveForwardTimeC(1.5));  
        addParallel(new TimerC(15));
        //addSequential(new EnableAndDissableButtons(true));
        addParallel(new WindWinchC(0));
        System.out.println("Wound Winch");
        addSequential(new LoadingArmDownC());
        System.out.println("Loading Down");
        addSequential(new ShooterLatchOpenC());
        System.out.println("Latch Open");
        addSequential(new FootDownC());
        System.out.println("Foot down");
        addParallel(new LoadingArmUpC());
        System.out.println("Loading Arm");
        addSequential(new LoosenWinchAndLatchC());
        System.out.println("Loosen Winch");
        addSequential(new WindWinchC(0));
        System.out.println("Wound Winch");// Add Commands here:
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
