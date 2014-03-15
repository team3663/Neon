package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;

public class LoosenWinchAndLatchC extends CommandBase {
    double currentTicks;
    double targetTicks = 720;
    double startTime;
    
    public LoosenWinchAndLatchC() {
        requires(shooterWinchAndLatchSS);
    }

    protected void initialize() {
        shooterWinchAndLatchSS.latchOpen();
        startTime = 0;
    }

    protected void execute() {
        shooterWinchAndLatchSS.setWinchSpeed(1);
    }

    protected boolean isFinished() {
         currentTicks = shooterWinchAndLatchSS.getWinchEncoder();

        if (currentTicks > targetTicks){
            return true;
        }

        if (catapultLimitSwitchSS.catapultIsDown() && (startTime == 0))
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~Latched and Winding~");
            shooterWinchAndLatchSS.readyToShoot = false;
            shooterWinchAndLatchSS.latchClose();
            startTime = Timer.getFPGATimestamp();
        }
        if (Timer.getFPGATimestamp() - startTime > .5 && (startTime != 0))
        {
            return true;
        }
        return false;
    }

    protected void end() {
        shooterWinchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        end();
    }
}
