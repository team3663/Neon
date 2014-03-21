package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class LoadingArmDownC extends CommandBase {
    
    double endTime;

    public LoadingArmDownC() {
    }

    protected void initialize() {
        System.out.println("LoadingArmDownC.initalize");
        loadingArmSS.loadingArmDown();
        endTime = Timer.getFPGATimestamp() + .5;
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
        System.out.println("LoadingArmDownC.end");
    }

    protected void interrupted() {
        System.out.println("LoadingArmDownC.interrupted");
    }
}
