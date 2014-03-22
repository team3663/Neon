package team3663.neon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team3663.neon.commands.AutonomousfinalCG;
import team3663.neon.commands.Bob;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.WindAndLatchToFullPowerCG;

public class Robot3663 extends IterativeRobot
{
    public static boolean mustard = true;
    boolean test = true;
    int counter=0;
    CommandGroup autonomousfinalCG;
    CommandGroup autonomousBackUpCG; 
    CommandBase bob;
    CommandGroup windWinchToFull;

    DriverStation driveStation;
    int isAliveCounter;
    public static boolean isTesting;
    public static double autoTimeStart;
    
    double updateStatusNextRefresh;
    final double UPDATESTATUSREFRESHINTERVAL = 0.25;

    
    public void robotInit() 
    {
        System.out.println("Robot3663.robotInit start");
        RobotMap.init();
        CommandBase.init();
        windWinchToFull = new WindAndLatchToFullPowerCG();
        autonomousfinalCG = new AutonomousfinalCG();
        //autonomousBackUpCG = new AutonomousBackUpCG();
        driveStation = DriverStation.getInstance();
        CommandBase.dsLCD.clear();
        updateStatusNextRefresh = Timer.getFPGATimestamp();
        updateStatus();
        System.out.println("Robot3663.robotInit end");
    }

    public void autonomousInit() 
    {
        isTesting = false;
        System.out.println("Robot3663.autonomousInit start");
        //autonomousBackUpCG.start();
        autoTimeStart = Timer.getFPGATimestamp();
        autonomousfinalCG.start();
        System.out.println("Robot3663.autonomousInit end");
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        //LiveWindow.run();
        updateStatus();
    }

    public void teleopInit() 
    {
        isTesting = false;
       // bob.start();
        System.out.println("Robot3663.teleopInit start");
        //autonomousBackUpCG.cancel();
        autonomousfinalCG.cancel();
        windWinchToFull.start();
        System.out.println("Robot3663.teleopInit end");
    }
    
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        //LiveWindow.run();
        updateStatus();
    }
    
    public void testInit() 
    {
        System.out.println("Robot3663.testInit start");
        LiveWindow.setEnabled(false);
        isTesting = true;
        autonomousfinalCG.cancel();
        System.out.println("Robot3663.testInit end");
    }

    public void testPeriodic() 
    {
        Scheduler.getInstance().run();
        //LiveWindow.run();
        updateStatus();
    }
    public void disabledInit() 
    {
        System.out.println("disableInit.start");
        System.out.println("disableInit.end");
    }
    public void disabledPeriodic()
    {
        //System.out.println("disablePeriodic.start");
        //System.out.println("disablePeriodic.end");
    }
    public void updateStatus()
    {
        double currentTime = Timer.getFPGATimestamp();
        if (currentTime >= updateStatusNextRefresh)
        {
            updateStatusNextRefresh += UPDATESTATUSREFRESHINTERVAL;
            if (currentTime > updateStatusNextRefresh)
                updateStatusNextRefresh = currentTime + UPDATESTATUSREFRESHINTERVAL;
            
            //SmartDashboard.putNumber("updateStatus:", isAliveCounter++);

            CommandBase.winchAndLatchSS.updateStatus();
            CommandBase.compressorSS.updateStatus();
            CommandBase.driveTrainSS.updateStatus();
            CommandBase.footSS.updateStatus(); 
            CommandBase.catapultLimitSwitchSS.updateStatus();
            CommandBase.hammerSS.updateStatus();
            CommandBase.winchAndLatchSS.updateStatus();
            CommandBase.loadingArmSS.updateStatus();
            //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "Brian14 "+ counter++);
            CommandBase.dsLCD.updateLCD();
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "                     ");
            //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "                     ");
            //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6, 1, "                     ");
        }
    }
}
