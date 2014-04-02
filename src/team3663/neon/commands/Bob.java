package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Bob extends CommandBase {
    double endTime;
    double time;
    Command bob2;
    
    public Bob() {
        SmartDashboard.putNumber("Bob duration",7);
        bob2 = new Bob2();
        // eg. requires(chassis);
    }

    protected void initialize() {
        double duration = SmartDashboard.getNumber("Bob duration");
        endTime = duration + Timer.getFPGATimestamp();
        System.out.println("Bob has Initialized, duration = "+ duration);
        SmartDashboard.putNumber("Bob's current duration:", duration);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        
        double currentTime = Timer.getFPGATimestamp();
        if( currentTime > endTime)
        {
            System.out.println("bob is done (isFinshed)");
            return true;
        }
        System.out.println("bob is running " + (endTime - currentTime));
        SmartDashboard.putNumber("Bob time:",(endTime - currentTime));
        return false;
        
    }

    protected void end() {
        System.out.println("bob has ended");
        bob2.start();
        
    }

    protected void interrupted() {
        System.out.println("bob was interruped");
        end();
    }
}
