package team3663.neon.commands;

import team3663.neon.Robot3663;

public class C_LoadBall extends CommandBase {
    
    public C_LoadBall() {
        requires(armSS);
    }

    protected void initialize() {
        Robot3663.updateCommandStatus("C_LoadBall", "initialize");        
        footSS.footDown();
        armSS.armDown();
        armSS.armMotorIntake();
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
        Robot3663.updateCommandStatus("C_LoadBall", "end");        
    }

    protected void interrupted() {
        Robot3663.updateCommandStatus("C_LoadBall", "interrupted");        
        end();
    }
}
