package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class CatapultLimitSwitchMonitorC extends CommandBase {
    
    boolean catapultWasPreviouslyDown;
    boolean catapultIsReallyDown;
    double whenCatapultWentDown;
    
    public CatapultLimitSwitchMonitorC() {
        requires(catapultLimitSwitchSS);
    }

    protected void initialize() {
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
    }

    protected void interrupted() {
    }
}
