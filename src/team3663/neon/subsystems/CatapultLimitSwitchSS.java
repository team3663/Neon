package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.RobotMap;
import team3663.neon.commands.CatapultLimitSwitchMonitorC;

public class CatapultLimitSwitchSS extends Subsystem {
    boolean catapultIsReallyDown;
        
    public void initDefaultCommand() {
        setDefaultCommand(new CatapultLimitSwitchMonitorC());
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
        SmartDashboard.putBoolean("Catapult is Down", catapultIsReallyDown);
        //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Catapult down: " + catapultIsReallyDown);
    }
    
    
}
