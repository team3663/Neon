package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_HammerExtend extends CommandBase {
    
    double endTime;
    public P_HammerExtend() {
        requires(hammerSS);
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        hammerSS.hammerExtend();
    }

    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() >= endTime)
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
