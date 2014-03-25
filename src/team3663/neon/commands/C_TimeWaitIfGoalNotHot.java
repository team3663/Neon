package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_TimeWaitIfGoalNotHot extends CommandBase {

    double endTime;
    
    public C_TimeWaitIfGoalNotHot() {
    }

    protected void initialize() {
        SmartDashboard.putString("C_TimeWaitIfGoalNotHot", "Initialized");
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
        SmartDashboard.putString("C_TimeWaitIfGoalNotHot", "End");
    }

    protected void interrupted() {
        SmartDashboard.putString("C_TimeWaitIfGoalNotHot", "Interrupted");
    }
}
