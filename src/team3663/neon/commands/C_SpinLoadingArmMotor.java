package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_SpinLoadingArmMotor extends CommandBase {
    
    boolean intake;
    double endTime;
    double duration;
    
    public C_SpinLoadingArmMotor(boolean pIntake, double pDuration) {
        intake = pIntake;
        duration = pDuration;
        requires(loadingArmSS);
    }

    protected void initialize() {
        SmartDashboard.putString("C_SpinLoadingArmMotor", "Initialized");
        endTime = Timer.getFPGATimestamp() + duration;
        if (intake)
            loadingArmSS.loadingArmMotorIntake();
        else
            loadingArmSS.loadingArmMotorEject();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(Timer.getFPGATimestamp() >= endTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("C_SpinLoadingArmMotor", "End");
        loadingArmSS.loadingArmMotorStop();
    }

    protected void interrupted() {
        SmartDashboard.putString("C_SpinLoadingArmMotor", "Interrupted");
        end();
    }
}
