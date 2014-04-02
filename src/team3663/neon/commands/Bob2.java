package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Bob2 extends CommandBase {
    double endTime;
    double time;
    
    public Bob2() {
        SmartDashboard.putNumber("Bob2 duration",7);
        // eg. requires(chassis);
    }

    protected void initialize() {
        double duration = SmartDashboard.getNumber("Bob2 duration");
        endTime = duration + Timer.getFPGATimestamp();
        System.out.println("Bob2 has Initialized, duration = "+ duration);
        SmartDashboard.putNumber("Bob2's current duration:", duration);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        
        double currentTime = Timer.getFPGATimestamp();
        if( currentTime > endTime)
        {
            System.out.println("bob2 is done (isFinshed)");
            return true;
        }
        System.out.println("bob2 is running " + (endTime - currentTime));
        SmartDashboard.putNumber("Bob2 time:",(endTime - currentTime));
        return false;
        
    }

    protected void end() {
        System.out.println("bob2 has ended");
    }

    protected void interrupted() {
        System.out.println("bob2 was interruped");
        end();
    }
}
