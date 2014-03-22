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
        //addSequential(new EnableAndDissableButtons(true));
        addSequential(new WindWinchC(shotStrength));     
        addSequential(new LoadingArmDownC());   
        addSequential(new LatchOpenC());
        addSequential(new FootDownC());
        addParallel(new LoadingArmUpC());
        addSequential(new LoosenWinchAndLatchC());
       
        addSequential(new WindWinchC(0));

    }
}
