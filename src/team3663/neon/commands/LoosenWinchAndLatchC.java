package team3663.neon.commands;

public class LoosenWinchAndLatchC extends CommandBase {
    
    double targetTicks = 500;
    
    public LoosenWinchAndLatchC() {
        requires(shooterWinchAndLatchSS);
    }

    protected void initialize() {
    }

    protected void execute() {
        shooterWinchAndLatchSS.setWinchSpeed(1);
    }

    protected boolean isFinished() {
        double currentTicks = shooterWinchAndLatchSS.getWinchEncoder();

        if (currentTicks > targetTicks){
            return true;
        }

        if (catapultLimitSwitchSS.catapultIsDown())
        {
            shooterWinchAndLatchSS.latchClose();
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
