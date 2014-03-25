package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_FootDown extends CommandBase {
    double endTime;
    public P_FootDown() {
       // requires(footSS);
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + .5;
    }

    protected void execute() {
        footSS.footDown();
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
