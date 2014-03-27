package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_LoosenWinchAndLatch extends CommandBase {
    double currentTicks;
    double targetTicks = 710;
    double startTime;
    double speed;
    boolean kill;
    public C_LoosenWinchAndLatch() {
        requires(winchAndLatchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("C_LoosenWinchAndLatch", "initialize");      
        startTime = 0;
        speed = 0;
        if(!catapultLimitSwitchSS.catapultIsDown())
        {
            speed = 1;
            winchAndLatchSS.latchOpen();
            kill = false;
        }    
        else 
        {
            kill = true;
        }
    }

    protected void execute() {
        winchAndLatchSS.setWinchSpeed(speed);
    }

    protected boolean isFinished() {
         currentTicks = winchAndLatchSS.getWinchEncoder();
         if(kill)
         {
             return true;
         }

        if (currentTicks > targetTicks){
            SmartDashboard.putString("Problem", "C_LoosenWinchAndLatch exceeded target ticks");        
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~Latch Missed!!!~");
            return true;
        }

        if (catapultLimitSwitchSS.catapultIsDown() && (startTime == 0))
        {
            winchAndLatchSS.latchClose();
            startTime = Timer.getFPGATimestamp();
        }
        if ((Timer.getFPGATimestamp() - startTime > .5) && (startTime != 0))
        {
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "~Latched and Winding~");
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("C_LoosenWinchAndLatch", "end");        
        winchAndLatchSS.setWinchSpeed(0);
    }

    protected void interrupted() {
        SmartDashboard.putString("C_LoosenWinchAndLatch", "interrupted");        
        end();
    }
}
