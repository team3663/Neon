package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoadBallC extends CommandBase {
    
    public LoadBallC() {
        requires(loadingArmSS);
    }

    protected void initialize() {
        loadingArmSS.loadingArmDown();
        loadingArmSS.loadingArmMotorIntake();
        footSS.footDown();
        SmartDashboard.putString("LoadBallC", "initialize");        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        footSS.footUp();
        loadingArmSS.loadingArmUp();
        loadingArmSS.loadingArmMotorStop();
        SmartDashboard.putString("LoadBallC", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("LoadBallC", "interrupted");        
        end();
    }
}
