/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Angelique
 */
public class Karel extends CommandBase {
    
    int startTime;
    int lastSecondTime;
    boolean executeShouldPrint;
    
    public Karel() {
        System.out.println("Karel");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lastSecondTime = startTime = (int)Timer.getFPGATimestamp();
        executeShouldPrint = true;
        System.out.println("Karel.initialize at " + startTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(executeShouldPrint){
            System.out.println("Karel.execute");
            executeShouldPrint = false;
        }
        
        //Timer.delay(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        int currentTime = (int)Timer.getFPGATimestamp();
        if(currentTime >= (startTime + 10)){
            System.out.println("Karel.isFinished, returning True");
            return true;
        }
        if(currentTime > lastSecondTime){
            System.out.println("Karel.isFinished time: " + (currentTime - startTime));
            lastSecondTime = currentTime;
            executeShouldPrint = true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Karel.end at " + lastSecondTime);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("Karel.interrupted \n Bob stop interrupting me...-_-");
    }
}
