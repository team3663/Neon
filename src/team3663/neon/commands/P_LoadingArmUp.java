package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_LoadingArmUp extends CommandBase {
    
    double endTime;
    public P_LoadingArmUp() {
    }

    protected void initialize() {
        loadingArmSS.loadingArmUp();
        endTime = Timer.getFPGATimestamp() + 1;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() > endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
