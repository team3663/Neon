package team3663.neon.commands;
 
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team3663.neon.OI;
import team3663.neon.subsystems.CatapultLimitSwitchSS;
import team3663.neon.subsystems.ArmSS;
import team3663.neon.subsystems.CompressorSS;
import team3663.neon.subsystems.DriveTrainSS;
import team3663.neon.subsystems.FootSS;
import team3663.neon.subsystems.HammerSS;
import team3663.neon.subsystems.WinchAndLatchSS;
import team3663.neon.subsystems.ImageProcessing;
import team3663.neon.subsystems.ImageProcessing2;

public abstract class CommandBase extends Command 
{
    public static OI oi;
    public static boolean isShoot;
    public static DriveTrainSS driveTrainSS; 
    public static CompressorSS compressorSS;
    public static FootSS footSS;
    public static WinchAndLatchSS winchAndLatchSS;
    public static HammerSS hammerSS;
    public static ArmSS armSS;
    public static CatapultLimitSwitchSS catapultLimitSwitchSS;
    public static ImageProcessing2 imageProcess2;
    
    public static DriverStationLCD dsLCD;
    
    public static Timer timer;
    
    public static void init() 
    {
        compressorSS = new CompressorSS();
        driveTrainSS = new DriveTrainSS();
        driveTrainSS.Init();
        footSS = new FootSS();
        hammerSS = new HammerSS();
        armSS = new ArmSS();      
        winchAndLatchSS = new WinchAndLatchSS();
        catapultLimitSwitchSS = new CatapultLimitSwitchSS();

        imageProcess2 = new ImageProcessing2();
        //imageProcess2.Init(); //called from processCameraImage so camera detection only happens as needed

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
