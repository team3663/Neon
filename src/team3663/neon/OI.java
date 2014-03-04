package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.HammerRetractC;
import team3663.neon.commands.TractionWheelsDownC;
import team3663.neon.commands.ShiftToHighGearC;
import team3663.neon.commands.ShiftToLowGearC;
import team3663.neon.commands.TractionWheelsUpC;
import team3663.neon.commands.ChectForHotZoneC;
import team3663.neon.commands.FillAirTanksC;
import team3663.neon.commands.FootDownC;
import team3663.neon.commands.FootUpC;
import team3663.neon.commands.HammerExtendC;
import team3663.neon.commands.LoadingArmDownC;
import team3663.neon.commands.LoadingArmUpC;
import team3663.neon.commands.ShooterLatchCloseC;
import team3663.neon.commands.ShooterLatchOpenC;

public class OI 
{
    private final Joystick driveJoystick;
    private final Joystick turnJoystick;

    private static JoystickButton changeToArcadeDrive;
    private static JoystickButton changeToMecanumDrive;
    private static JoystickButton switchToHighGear;
    private static JoystickButton switchToLowGear;
    private static JoystickButton hammer;
    private static JoystickButton imageOn;
    
    public OI()
    {
        System.out.println("OI constructor start");

        driveJoystick = new Joystick(1);
        turnJoystick = new Joystick(2);
        
        imageOn = new JoystickButton(driveJoystick, 1);
        imageOn.whenPressed(new ChectForHotZoneC());
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 3);
        changeToMecanumDrive.whenPressed(new TractionWheelsUpC());
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new ShiftToLowGearC());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 5);
        changeToArcadeDrive.whenPressed(new TractionWheelsDownC());
        
        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new ShiftToHighGearC());
        
        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new HammerRetractC());
        
        SmartDashboard.putData("ChectForHotZone", new ChectForHotZoneC());
        SmartDashboard.putData("FillAirTanks", new FillAirTanksC());
        SmartDashboard.putData("FootDown", new FootDownC());
        SmartDashboard.putData("FootUp", new FootUpC());
        SmartDashboard.putData("HammerRetract", new HammerRetractC());
        SmartDashboard.putData("HammerExtendC", new HammerExtendC());
        SmartDashboard.putData("LoadingArmDown", new LoadingArmDownC());
        SmartDashboard.putData("LoadingArmUp", new LoadingArmUpC());
        SmartDashboard.putData("ShiftToLowGear", new ShiftToLowGearC());
        SmartDashboard.putData("ShiftToHighGear", new ShiftToHighGearC());
        SmartDashboard.putData("TractionWheelsDown", new TractionWheelsDownC());
        SmartDashboard.putData("TractionWheelsUp", new TractionWheelsUpC());
        SmartDashboard.putData("ShooterLatchClose", new ShooterLatchCloseC());
        SmartDashboard.putData("ShooterLatchOpen", new ShooterLatchOpenC());
        
        System.out.println("OI constructor end");
    }
    
    public Joystick getDriveJoystick() 
    {
	return driveJoystick;
    }
    
    public Joystick getTurnJoystick() 
    {
	return turnJoystick;
    }
}

