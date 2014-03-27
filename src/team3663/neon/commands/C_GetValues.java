/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author curtis
 */
public class C_GetValues extends CommandBase {
    double param1;
    double param2;
    double param3;
    Command command;
    public C_GetValues(double pParam1, double pParam2, double pParam3) {
        SmartDashboard.putNumber("param1", pParam1);
        SmartDashboard.putNumber("param2", pParam2);        
        SmartDashboard.putNumber("param3", pParam3);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {       
        param1 = SmartDashboard.getNumber("param1");
        param2 = SmartDashboard.getNumber("param2");
        param3 = SmartDashboard.getNumber("param3");
        command = new C_DriveForwardTime(param1, param2, param3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        command.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
