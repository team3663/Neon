package team3663.neon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.CG_AutonomousComplete;
import team3663.neon.commands.CG_AutonomousMoveAndShoot;
import team3663.neon.commands.CG_WindAndLatchToFullPower;
import team3663.neon.commands.C_Drive;
import team3663.neon.commands.CommandBase;

public class Robot3663 extends IterativeRobot
{
    int counter=0;
    CommandGroup autonomousCG;
    CommandGroup loosenAndWindWinch;
    //CommandBase c_Drive;
    SendableChooser autoChooser;
    public static String CG_SmartDash;
    public static String C_SmartDash;

    DriverStation driveStation;
    int isAliveCounter;
    public static boolean isTesting;
    public static double autoTimeStart;
    
    double updateStatusNextRefresh;
    final double UPDATESTATUSREFRESHINTERVAL = 0.2;

    
    public void robotInit() 
    {
        System.out.println("Robot3663.robotInit start");
        RobotMap.init();
        CommandBase.init();
        loosenAndWindWinch = new CG_WindAndLatchToFullPower();
        //autoChooser = new SendableChooser();
        //autoChooser.addDefault("AutonomousComplete", new CG_AutonomousComplete());
        //autoChooser.addObject("AutonomousMoveAndShootOnly", new CG_AutonomousMoveAndShoot());
       // SmartDashboard.putData("Autonomous Chooser", autoChooser);
        autonomousCG = new CG_AutonomousMoveAndShoot();
        //autonomousCG = (CommandGroup) autoChooser.getSelected();
        
        //c_Drive = new C_Drive();
        driveStation = DriverStation.getInstance();
        driveStation.getBatteryVoltage();
        CommandBase.dsLCD.clear();
        updateStatusNextRefresh = Timer.getFPGATimestamp();
        clearSmartDashboard();
        updateStatus();
        System.out.println("Robot3663.robotInit end");
    }

    public void autonomousInit() 
    {
        isTesting = false;
        System.out.println("Robot3663.autonomousInit start");
        autoTimeStart = Timer.getFPGATimestamp();
        autonomousCG.start();
        System.out.println("Robot3663.autonomousInit end");
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        updateStatus();
    }

    public void teleopInit() 
    {
        autonomousCG.cancel();
        //c_Drive.start();
        loosenAndWindWinch.start();
        isTesting = false;
        System.out.println("Robot3663.teleopInit start");
        System.out.println("Robot3663.teleopInit end");
    }
    
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        updateStatus();
    }
    
    public void testInit() 
    {
        autonomousCG.cancel();
        System.out.println("Robot3663.testInit start");
        LiveWindow.setEnabled(false);
        isTesting = true;
        System.out.println("Robot3663.testInit end");
    }

    public void testPeriodic() 
    {
        Scheduler.getInstance().run();
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
    public void clearSmartDashboard()
    {
        CG_SmartDash = "-reset-";
        C_SmartDash = "-reset-";
        /*
        SmartDashboard.putString("Arm", "-reset-");
        SmartDashboard.putString("Catapult", "-reset-");
        SmartDashboard.putString("Air tanks", "-reset-");
        SmartDashboard.putString("Compressor", "-reset-");
        SmartDashboard.putString("Gear","-reset-");
        SmartDashboard.putString("Traction wheels","-reset-");
        SmartDashboard.putString("Driving mode", "-reset-");
        SmartDashboard.putString("Foot","-reset-");
        SmartDashboard.putString("Hammer","-reset-");
        SmartDashboard.putString("Goal", "-reset-");
        SmartDashboard.putString("Latch","-reset-");
        */
    }
    public void updateStatus()
    {
        double currentTime = Timer.getFPGATimestamp();
        if (currentTime >= updateStatusNextRefresh)
        {
            updateStatusNextRefresh = currentTime + UPDATESTATUSREFRESHINTERVAL;
            
            //SmartDashboard.putNumber("updateStatus:", isAliveCounter++);
            SmartDashboard.putString("CG_Commands", CG_SmartDash);
            SmartDashboard.putString("Commands", C_SmartDash);
            SmartDashboard.putNumber("BatteryVoltage", driveStation.getBatteryVoltage());
            SmartDashboard.putNumber("MatchTime", driveStation.getMatchTime());
            
            CommandBase.winchAndLatchSS.updateStatus();
            CommandBase.compressorSS.updateStatus();
            CommandBase.driveTrainSS.updateStatus();
            CommandBase.footSS.updateStatus(); 
            CommandBase.catapultLimitSwitchSS.updateStatus();
            CommandBase.hammerSS.updateStatus();
            CommandBase.winchAndLatchSS.updateStatus();
            CommandBase.armSS.updateStatus();
            CommandBase.imageProcess.updateStatus();

            if(isOperatorControl())
            {
                SmartDashboard.putString("RobotState", "Teleoperated");
            }
            else if(isAutonomous())
            {
                SmartDashboard.putString("RobotState", "Autonomous");
            }
            else if(isTest())
            {
                SmartDashboard.putString("RobotState", "Test");
            }
            else
            {
                SmartDashboard.putString("RobotState", "Unknown");
            }
            //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "Brian14 "+ counter++);
            CommandBase.dsLCD.updateLCD();
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser1, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser3, 1, "                     ");
            //CommandBase.dsLCD.println(DriverStationLCD.Line.kUser4, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser5, 1, "                     ");
            CommandBase.dsLCD.println(DriverStationLCD.Line.kUser6, 1, "                     ");

        }
    }
    
    public static void updateCommandStatus(String command, String state)
    {
        //this is lossy
        C_SmartDash = command + " " + state;
    }
    
    public static void updateCGStatus(String command, String state)
    {
        //this is lossy
        CG_SmartDash = command + " " + state;
    }
}
