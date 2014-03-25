package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.C_CatapultLimitSwitchMonitor;

public class CatapultLimitSwitchSS extends Subsystem {
    boolean catapultIsReallyDown;
        
    public void initDefaultCommand() {
        setDefaultCommand(new C_CatapultLimitSwitchMonitor());
    }
    
    public boolean catapultIsDownRaw()
    {
        return !RobotMap.shooterLimitSwitchDIO.get();
    }
    
    public boolean catapultIsDown()
    {
        return catapultIsReallyDown;
    }
    
    public void putCatapultIsDown(boolean pCatapultState)
    {
        catapultIsReallyDown = pCatapultState;
    }
    public void updateStatus(){
        if (catapultIsReallyDown)
            SmartDashboard.putString("Catapult is ", "down");
        else
            SmartDashboard.putString("Catapult is ", "up");
        //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Catapult down: " + catapultIsReallyDown);
    }
    
    
}
