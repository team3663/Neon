package team3663.neon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.AutonomousBackUpCG;
import team3663.neon.commands.Bob;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.WindAndLatchToFullPowerCG;

public class Robot3663 extends IterativeRobot
{
    public static boolean mustard = true;
    boolean test = true;
    int counter=0;
    CommandGroup autonomousCG;
    CommandGroup autonomousBackUpCG; 
    CommandBase bob;
    CommandGroup windWinchToFull;

    DriverStation driveStation;
    int isAliveCounter;
    
    public void robotInit() 
    {
        System.out.println("Robot3663.robotInit start");
        RobotMap.init();
        CommandBase.init();
        
        bob = new Bob();
        windWinchToFull = new WindAndLatchToFullPowerCG();
        //autonomousCG = new AutonomousCG();
        autonomousBackUpCG = new AutonomousBackUpCG();
        driveStation = DriverStation.getInstance();
        CommandBase.dsLCD.clear();
        updateStatus();
        System.out.println("Robot3663.robotInit end");
    }

    public void autonomousInit() 
    {
        System.out.println("Robot3663.autonomousInit start");
        autonomousBackUpCG.start();
        //autonomousCG.start();
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
        windWinchToFull.start();
       // bob.start();
        System.out.println("Robot3663.teleopInit start");
        autonomousBackUpCG.cancel();
        //autonomousCG.cancel();
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
        //autonomousCG.cancel();
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
        SmartDashboard.putNumber("updateStatus", isAliveCounter++);

        CommandBase.shooterWinchAndLatchSS.updateStatus();
        CommandBase.compressorSS.updateStatus();
        CommandBase.driveTrainSS.updateStatus();
        CommandBase.footSS.updateStatus(); 
        CommandBase.catapultLimitSwitchSS.updateStatus();
        CommandBase.hammerSS.updateStatus();
        CommandBase.shooterWinchAndLatchSS.updateStatus();
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
