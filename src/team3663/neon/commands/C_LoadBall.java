package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_LoadBall extends CommandBase {
    
    public C_LoadBall() {
        requires(armSS);
    }

    protected void initialize() {
        footSS.footDown();
        armSS.armDown();
        armSS.armMotorIntake();
        SmartDashboard.putString("C_LoadBall", "initialize");        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        footSS.footUp();
        armSS.armUp();
        armSS.armMotorStop();
        SmartDashboard.putString("C_LoadBall", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("C_LoadBall", "interrupted");        
        end();
    }
}
