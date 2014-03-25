package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_CatapultLimitSwitchMonitor extends CommandBase {
    
    boolean catapultWasPreviouslyDown;
    boolean catapultIsReallyDown;
    double whenCatapultWentDown;
    
    public C_CatapultLimitSwitchMonitor() {
        requires(catapultLimitSwitchSS);
    }

    protected void initialize() {
        SmartDashboard.putString("C_CatapultLimitSwitchMoitor", "Initialized");
        whenCatapultWentDown = 0;
        if (catapultLimitSwitchSS.catapultIsDownRaw())
            catapultIsReallyDown = catapultWasPreviouslyDown = true;
        else
            catapultIsReallyDown = catapultWasPreviouslyDown = false;
        catapultLimitSwitchSS.putCatapultIsDown(catapultIsReallyDown);
    }

    protected void execute() {

        boolean catapultIsCurrentlyDown = catapultLimitSwitchSS.catapultIsDownRaw();

        if (!catapultIsCurrentlyDown)
        {
            catapultWasPreviouslyDown = false;
            catapultIsReallyDown = false;
        }
        else
        {
            double currentTime = Timer.getFPGATimestamp();
            if (!catapultWasPreviouslyDown)
            {
                catapultWasPreviouslyDown = true;
                whenCatapultWentDown = currentTime;
            }
            else if (!catapultIsReallyDown)
            {
                if (currentTime - whenCatapultWentDown > .25)
                {
                    catapultIsReallyDown = true;
                }
            }
        }
        catapultLimitSwitchSS.putCatapultIsDown(catapultIsReallyDown);  
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        SmartDashboard.putString("C_CatapultLimitSwitchMoitor", "End");
    }

    protected void interrupted() {
        SmartDashboard.putString("C_CatapultLimitSwitchMoitor", "Interupted");
    }
}
