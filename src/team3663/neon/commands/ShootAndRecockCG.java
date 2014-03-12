/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3663.neon.Robot3663;

/**
 *
 * @author briking
 */
public class ShootAndRecockCG extends CommandGroup {
    
    public ShootAndRecockCG(double shotStrength) { //**** Delete parameter
        //addSequential(new EnableAndDissableButtons(true));
        boolean weAreShooting = false;
        addSequential(new WindWinchC(shotStrength)); //***** Needs deletion
        if(shotStrength == 200){
            if(Robot3663.shot != "weak"){
                addSequential(new WindWinchC(200));
                weAreShooting = false;
            }
            else {
                weAreShooting = true;
            }
        }
        else if(shotStrength == 100){
            if(Robot3663.shot != "medium"){
                addSequential(new WindWinchC(100));
                weAreShooting = false;
            }
            else{
                weAreShooting = true;
            }
        }
        else if(shotStrength == 0){
            if(Robot3663.shot != "full"){
                addSequential(new WindWinchC(0));
                weAreShooting = false;
            }
            else{
                weAreShooting = true;
            }
        }
        if(weAreShooting){
            addSequential(new LoadingArmDownC());   
            addSequential(new ShooterLatchOpenC());
            addSequential(new FootDownC());
            addParallel(new LoadingArmUpC());
            addSequential(new LoosenWinchAndLatchC());
            addSequential(new WindWinchC(0));
        }
        
        
        //addSequential(new EnableAndDissableButtons(false));
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
