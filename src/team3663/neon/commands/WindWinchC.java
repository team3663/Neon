package team3663.neon.commands;

public class WindWinchC extends CommandBase {
    
    double targetTicks;
    boolean tighten;
    double speed;
    double direction;
    
    public WindWinchC(double pTargetTicks) {
        requires(shooterWinchAndLatchSS);
        targetTicks = pTargetTicks;
    }

    //encoder tightens using negative speed
    //encoder counts deacrese when tightened
    protected void initialize() {
        tighten = shooterWinchAndLatchSS.getWinchEncoder() > targetTicks;
        
        if (tighten){
            direction = speed = -1;
        }
        else{
            direction = speed = 1;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterWinchAndLatchSS.setWinchSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentTicks = shooterWinchAndLatchSS.getWinchEncoder();
        
        //stop if goal passed
        if (tighten){
            if (currentTicks < targetTicks){
                return true;
            }
        } else {
            if (currentTicks > targetTicks){
                return true;
            }
        }

        double ticksToGo = targetTicks - currentTicks;
        if (ticksToGo < 0)
            ticksToGo = -ticksToGo;

        if (ticksToGo < 15)
            return true;
        else if (ticksToGo < 30)
            speed = .25 * direction;
        else if (ticksToGo < 45)
            speed = .5 * direction;
        else if (ticksToGo < 60)
            speed = .75 * direction;
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooterWinchAndLatchSS.setWinchSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
