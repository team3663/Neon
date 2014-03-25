package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_TractionWheelsDown extends CommandBase {
    double endTime;
    public P_TractionWheelsDown() {
        requires(driveTrainSS);
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + 0.25;
        driveTrainSS.TractionWheelsDown();
    }

    protected void execute() {
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
