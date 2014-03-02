package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
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

public abstract class CommandBase extends Command 
{
    public static OI oi;
    public static DriveTrain driveTrain; 
    public static Compressor compressor;
    public static Photoelectric photoelectric;
    public static Motor motor;
    public static ImageProcessing imageProcess;
    public static Ultrasonic ultraSonic;
    public static ShooterSystem shooterSystem;
    public static Hammer hammer;
    public static BallHandler ballHandler;
    public static DriverStationLCD dsLCD;
    
    public static void init() 
    {
        imageProcess = new ImageProcessing();        
        driveTrain = new DriveTrain();        
        ballHandler = new BallHandler();      
        compressor = new Compressor();
        ultraSonic = new Ultrasonic();
        shooterSystem = new ShooterSystem();
        photoelectric = new Photoelectric();
        motor = new Motor();
        hammer = new Hammer();
        dsLCD = DriverStationLCD.getInstance();
        
        oi = new OI();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
