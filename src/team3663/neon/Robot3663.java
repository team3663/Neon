package team3663.neon;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.CommandBase;
import team3663.neon.commands.AutonomousCommand;

public class Robot3663 extends IterativeRobot
{
    boolean test = true;
    //Command driveCommand;
    Command autonomousCommand;
    //Command rangeFinderCommand;
    DriverStation driveStation;
    //TargetCommand targetCommand;
    
    public void robotInit() 
    {
        RobotMap.init();
        CommandBase.init();
        
        //driveCommand = new DriveCommand();
        //rangeFinderCommand = new RangeFinder();
        autonomousCommand = new AutonomousCommand();
        driveStation = DriverStation.getInstance();
        UpdateStatus();
        System.out.println("robotInit");
        
    }

    public void autonomousInit() 
    {
        autonomousCommand.start();
        System.out.println("after autocommmand is called");
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        LiveWindow.run();
        UpdateStatus();
    }

    public void teleopInit() 
    {
        LiveWindow.setEnabled(true);
        autonomousCommand.cancel();
    }
    
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        LiveWindow.run();
        UpdateStatus();
    }
    
    public void testPeriodic() 
    {
        SmartDashboard.getBoolean("live window on:", test);
        System.out.println(test);
        //LiveWindow.setEnabled(false);
        Scheduler.getInstance().run();
        LiveWindow.run();
        UpdateStatus();
    }
    
    public void UpdateStatus()
    {
        CommandBase.driveTrain.UpdateStatus();
        CommandBase.photoelectric.UpdateStatus();
	CommandBase.dsLCD.updateLCD();
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1, 1, "                     ");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "                     ");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "                     ");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "                     ");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "                     ");
        CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6, 1, "                     ");
    }
}
