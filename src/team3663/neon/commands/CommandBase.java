package team3663.neon.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;
import team3663.neon.OI;
import team3663.neon.subsystems.CatapultLimitSwitchSS;
import team3663.neon.subsystems.LoadingArmSS;
import team3663.neon.subsystems.CompressorSS;
import team3663.neon.subsystems.DriveTrainSS;
import team3663.neon.subsystems.FootSS;
import team3663.neon.subsystems.HammerSS;
import team3663.neon.subsystems.ShooterWinchAndLatchSS;

public abstract class CommandBase extends Command 
{
    public static OI oi;
    public static DriveTrainSS driveTrainSS; 
    public static CompressorSS compressorSS;
    public static FootSS footSS;
    public static ShooterWinchAndLatchSS shooterWinchAndLatchSS;
    public static HammerSS hammerSS;
    public static LoadingArmSS loadingArmSS;
    public static CatapultLimitSwitchSS catapultLimitSwitchSS;
    
    public static DriverStationLCD dsLCD;
    
    public static void init() 
    {
         System.out.println("CommandBase.init start");

        compressorSS = new CompressorSS();
        driveTrainSS = new DriveTrainSS();
        footSS = new FootSS();
        hammerSS = new HammerSS();
        loadingArmSS = new LoadingArmSS();      
        shooterWinchAndLatchSS = new ShooterWinchAndLatchSS();
        catapultLimitSwitchSS = new CatapultLimitSwitchSS();

        dsLCD = DriverStationLCD.getInstance();
        
        oi = new OI();
        
        System.out.println("CommandBase.init end");
    }

    public CommandBase(String name) {
        super(name);
        System.out.println("CommandBase constructor start");
        System.out.println("CommandBase constructor end");
    }

    public CommandBase() {
        super();
        System.out.println("CommandBase constructor start");
        System.out.println("CommandBase constructor end");
    }
}
