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
public class FireWithArmUpCG extends CommandGroup {
    
    public FireWithArmUpCG(double shotStrength) {
        addSequential(new WindWinchC(shotStrength));    
        addSequential(new LatchOpenC());
        addSequential(new FootDownC());
        addParallel(new LoadingArmUpC());
        addSequential(new LoosenWinchAndLatchC());      
        addSequential(new WindWinchC(0));
    }
}
