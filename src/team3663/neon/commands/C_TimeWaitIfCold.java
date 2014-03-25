package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class C_TimeWaitIfCold extends CommandBase {

    double endTime;
    
    public C_TimeWaitIfCold() {
    }

    protected void initialize() {
        imageProcess.processCameraImage();
        if (imageProcess.hotTargetFound())
            endTime = 0;
        else
            endTime = Timer.getFPGATimestamp() + 5;
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
