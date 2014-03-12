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
public class TestAllPartsOfTheRobotCG extends CommandGroup {
    
    public TestAllPartsOfTheRobotCG() {
        
        double interCommandDelay = .25;
        
        //compressor
        addSequential(new WaitForCompressorC());
        
        //winch and latch
        addSequential(new WindWinchC(400));
        
        addSequential(new ShooterLatchCloseC());
        
        addSequential(new ShooterLatchOpenC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new ShooterLatchCloseC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new WindWinchC(0));  
        
        //traction wheels
        addSequential(new TractionWheelsDownC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new TractionWheelsUpC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new TractionWheelsDownC());
        
        //gear shifting
        addSequential(new ShiftToHighGearC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new ShiftToLowGearC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new ShiftToHighGearC());
        
        //hammer
        addSequential(new HammerRetractC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new HammerExtendC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new HammerRetractC());

        //foot
        addSequential(new FootUpC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new FootDownC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new FootUpC());
        
        //loading arm
        addSequential(new LoadingArmUpC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new LoadingArmDownC());
        addSequential(new TimeWaitC(interCommandDelay));
        
        addSequential(new SpinLoadingArmMotorC(true, 2.0));
        addSequential(new TimeWaitC(interCommandDelay));
        addSequential(new SpinLoadingArmMotorC(false, 2.0));
        
        addSequential(new LoadingArmUpC());
        addSequential(new TimeWaitC(interCommandDelay));

        addSequential(new DriveMotorTestC(1, 2, .5));
        addSequential(new DriveMotorTestC(2, 2, .5));
        addSequential(new DriveMotorTestC(3, 2, .5));
        addSequential(new DriveMotorTestC(4, 2, .5));

}
}
