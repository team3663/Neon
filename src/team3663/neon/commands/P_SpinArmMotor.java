package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        SmartDashboard.putString("P_SpinArmMotor", "Initialize");
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
        SmartDashboard.putString("P_SpinArmMotor", "End");
        armSS.armMotorStop();
    }

    protected void interrupted() {
        SmartDashboard.putString("P_SpinArmMotor", "Interrupted");
        end();
    }
}
