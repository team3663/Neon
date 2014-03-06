package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.DriveBasedOnEncodersC;
import team3663.neon.commands.HammerRetractC;
import team3663.neon.commands.TractionWheelsDownC;
import team3663.neon.commands.ShiftToHighGearC;
import team3663.neon.commands.ShiftToLowGearC;
import team3663.neon.commands.TractionWheelsUpC;
import team3663.neon.commands.FillAirTanksC;
import team3663.neon.commands.FootDownC;
import team3663.neon.commands.FootUpC;
import team3663.neon.commands.HammerExtendC;
import team3663.neon.commands.LoadBallC;
import team3663.neon.commands.LoadingArmDownC;
import team3663.neon.commands.LoadingArmUpC;
import team3663.neon.commands.LoosenWinchAndLatchC;
import team3663.neon.commands.ResetWinchEncoderC;
import team3663.neon.commands.ShootAndRecockCG;
import team3663.neon.commands.ShooterLatchCloseC;
import team3663.neon.commands.ShooterLatchOpenC;
import team3663.neon.commands.WindWinchC;

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
    private static JoystickButton loadBall;
    private static JoystickButton shoot;
    private static JoystickButton shootMedium;
    private static JoystickButton shootWeak;
    
    public OI()
    {
        System.out.println("OI constructor start");

        driveJoystick = new Joystick(1);
        turnJoystick = new Joystick(2);
        
        loadBall = new JoystickButton(driveJoystick, 1);
        loadBall.whileHeld(new LoadBallC());

        shoot = new JoystickButton(driveJoystick, 2);
        shoot.whenPressed(new ShootAndRecockCG(0));

        changeToMecanumDrive = new JoystickButton(driveJoystick, 5);
        changeToMecanumDrive.whenPressed(new TractionWheelsUpC());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 3);
        changeToArcadeDrive.whenPressed(new TractionWheelsDownC());

        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new ShiftToHighGearC());
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new ShiftToLowGearC());
        
        shootMedium = new JoystickButton(driveJoystick, 7);
        shootMedium.whenPressed(new ShootAndRecockCG(30));

        shootWeak = new JoystickButton(driveJoystick, 8);
        shootWeak.whenPressed(new ShootAndRecockCG(60));

        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new HammerRetractC());
        
        SmartDashboard.putData("loadBall", new LoadBallC());
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
        SmartDashboard.putData("ShooterLatchOpen", new ShooterLatchOpenC());
        SmartDashboard.putData("ShooterLatchClose", new ShooterLatchCloseC());
        SmartDashboard.putData("WindWinch_0", new WindWinchC(0));
        SmartDashboard.putData("WindWinch_30", new WindWinchC(30));
        SmartDashboard.putData("WindWinch_60", new WindWinchC(60));
        SmartDashboard.putData("WindWinch_120", new WindWinchC(120));
        SmartDashboard.putData("WindWinch_360", new WindWinchC(360));
        SmartDashboard.putData("WindWinch_500", new WindWinchC(500));
        SmartDashboard.putData("WindWinch_-50", new WindWinchC(-50));
        SmartDashboard.putData("ResetWinchEncoder", new ResetWinchEncoderC());
        SmartDashboard.putData("LoosenWinchAndLatch", new LoosenWinchAndLatchC());
        SmartDashboard.putData("ShootAndRecockCG", new ShootAndRecockCG(0));
        SmartDashboard.putData("DriveBasedOnEncodersC(2000,2000)", new DriveBasedOnEncodersC(2000,2000));
        SmartDashboard.putData("DriveBasedOnEncodersC(20000,0)", new DriveBasedOnEncodersC(20000,0));
        SmartDashboard.putData("DriveBasedOnEncodersC(0,-20000)", new DriveBasedOnEncodersC(0,-20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-20000,-20000)", new DriveBasedOnEncodersC(-20000,-20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(10000,20000)", new DriveBasedOnEncodersC(10000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(20000,20000)", new DriveBasedOnEncodersC(20000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-6000,20000)", new DriveBasedOnEncodersC(-6000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-20000,20000)", new DriveBasedOnEncodersC(-20000,20000));
    
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

