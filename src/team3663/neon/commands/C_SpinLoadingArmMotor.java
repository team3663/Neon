package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

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
        loadingArmSS.loadingArmMotorStop();
    }

    protected void interrupted() {
        end();
    }
}
