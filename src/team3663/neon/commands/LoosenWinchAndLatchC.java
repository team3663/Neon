package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoosenWinchAndLatchC extends CommandBase {
    double currentTicks;
    double targetTicks = 720;
    double startTime;
    
    public LoosenWinchAndLatchC() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("LoosenWinchAndLatchC", "initialize");        
        winchAndLatchSS.latchOpen();
        startTime = 0;
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(1);
    }

    protected boolean isFinished() {
         currentTicks = winchAndLatchSS.getWinchEncoder();

        if (currentTicks > targetTicks){
            return true;
        }

        if (catapultLimitSwitchSS.catapultIsDown() && (startTime == 0))
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~Latched and Winding~");
            winchAndLatchSS.latchClose();
            startTime = Timer.getFPGATimestamp();
        }
        if (Timer.getFPGATimestamp() - startTime > .5 && (startTime != 0))
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("LoosenWinchAndLatchC", "end");        
        winchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        SmartDashboard.putString("LoosenWinchAndLatchC", "interrupted");        
        end();
    }
}
