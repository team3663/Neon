package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class P_SpinArmMotor extends CommandBase {
    
    boolean intake;
    double endTime;
    double duration;
    
    public P_SpinArmMotor(boolean pIntake, double pDuration) {
        intake = pIntake;
        duration = pDuration;
        requires(armSS);
    }

    protected void initialize() {
        endTime = Timer.getFPGATimestamp() + duration;
        if (intake)
            armSS.armMotorIntake();
        else
            armSS.armMotorEject();
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
        armSS.armMotorStop();
    }

    protected void interrupted() {
        end();
    }
}
