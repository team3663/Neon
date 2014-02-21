package team3663.neon.commands;

import edu.wpi.first.wpilibj.command.Command;
import team3663.neon.OI;
import team3663.neon.subsystems.BallHandler;
import team3663.neon.subsystems.Compressor;
import team3663.neon.subsystems.DriveTrain;
import team3663.neon.subsystems.Hammer;
import team3663.neon.subsystems.ImageProcessing;
import team3663.neon.subsystems.Motor;
import team3663.neon.subsystems.Photoelectric;
import team3663.neon.subsystems.ShooterSystem;
import team3663.neon.subsystems.Ultrasonic;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 */
public abstract class CommandBase extends Command 
{
    public static OI oi;
    public static DriveTrain driveTrain; 
    public static Compressor compressor;
    public static Photoelectric photoelectric;
    public static CommandsGlobalVars comGVars;
    public static Motor motor;
    public static ImageProcessing imageProcess;
    public static Ultrasonic ultraSonic;
    public static ShooterSystem shooterSystem;
    public static Hammer hammer;
    public static BallHandler ballHandler;
    
    public static void init() 
    {
        comGVars = new CommandsGlobalVars();
        comGVars.Init();
        
        imageProcess = new ImageProcessing();
        imageProcess.Init();
        
        driveTrain = new DriveTrain();
        driveTrain.Init();
        
        ballHandler = new BallHandler();
        ballHandler.Init();
        
        compressor = new Compressor();
        compressor.Init();
        
        ultraSonic = new Ultrasonic();
        ultraSonic.Init();
        
        shooterSystem = new ShooterSystem();
        shooterSystem.Init();
        
        photoelectric = new Photoelectric();
        
        motor = new Motor();
        
        hammer = new Hammer();
        hammer.Init();
        
         
        oi = new OI();
        
       
      
        //photoelectric = new Photoelectric();
       
        //motor = new Motor();
       // mechanumDriveTrain = new MechanumDriveTrain();
        //imageProcess = new ImageProcessing();
        
        // Show what command your subsystem is running on the SmartDashboard
       // SmartDashboard.putData(driveTrain);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
