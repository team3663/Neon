package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.Bob;
import team3663.neon.commands.DriveForwardTimeC;
import team3663.neon.commands.HammerRetractC;
import team3663.neon.commands.TractionWheelsDownC;
import team3663.neon.commands.ShiftToHighGearC;
import team3663.neon.commands.ShiftToLowGearC;
import team3663.neon.commands.TractionWheelsUpC;
import team3663.neon.commands.FootDownC;
import team3663.neon.commands.FootUpC;
import team3663.neon.commands.HammerExtendC;
import team3663.neon.commands.HammerFireCG;
import team3663.neon.commands.LoadBallC;
import team3663.neon.commands.LoadingArmDownC;
import team3663.neon.commands.LoadingArmUpC;
import team3663.neon.commands.LoosenWinchAndLatchC;
import team3663.neon.commands.ResetWinchEncoderC;
import team3663.neon.commands.ShootAndRecockCG;
import team3663.neon.commands.ShooterLatchCloseC;
import team3663.neon.commands.ShooterLatchOpenC;
import team3663.neon.commands.TimeWaitC;
import team3663.neon.commands.WinchLoosenC;
import team3663.neon.commands.WinchTightenC;
import team3663.neon.commands.WindWinchC;


public class OI 
{
    private final Joystick driveJoystick;
    private final Joystick buttonJoystick;

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
    private static JoystickButton footUp;
    private static JoystickButton footDown;
    private static JoystickButton loosenWinch;
    private static JoystickButton tightenWinch;
    private static JoystickButton winchEncoderZero;
    private static JoystickButton LoosenWinchAndLatch;
    public OI()
    {
        System.out.println("OI constructor start");
//might be diffrent in mustard
        driveJoystick = new Joystick(1);
        buttonJoystick = new Joystick(2);
        
        SmartDashboard.putString("DriveLabel", "DriveStick");
        SmartDashboard.putString("MonkeyLabel", "ButtonMonkeyStick");
        
        
        LoosenWinchAndLatch = new JoystickButton(driveJoystick, 9);
        LoosenWinchAndLatch.whenPressed(new LoosenWinchAndLatchC());
        SmartDashboard.putString("Drive9:", "9: Loosen Winch & Latch");
        
        winchEncoderZero = new JoystickButton(driveJoystick, 10);
        winchEncoderZero.whenPressed(new WindWinchC(0));
        SmartDashboard.putString("Drive10:", "10: windWinch to 0");
        
        tightenWinch = new JoystickButton(driveJoystick, 12);
        tightenWinch.whileHeld(new WinchTightenC());
        SmartDashboard.putString("Drive12:", "12: Tighten Winch");
        
        loosenWinch = new JoystickButton(driveJoystick, 11);
        loosenWinch.whileHeld(new WinchLoosenC());
        SmartDashboard.putString("Drive11:", "11: Loosen Winch");
        
        loadBall = new JoystickButton(driveJoystick, 2);
        loadBall.whileHeld(new LoadBallC());
        SmartDashboard.putString("Drive2:", "2: pickUp arm down");

        shoot = new JoystickButton(buttonJoystick, 1);
        shoot.whenPressed(new ShootAndRecockCG(0));
        SmartDashboard.putString("Monkey1:", "1: SHOOT!");

        changeToMecanumDrive = new JoystickButton(driveJoystick, 5);
        changeToMecanumDrive.whenPressed(new TractionWheelsUpC());
        SmartDashboard.putString("Drive5:", "5: Traction Wheels Up");
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 3);
        changeToArcadeDrive.whenPressed(new TractionWheelsDownC());
        SmartDashboard.putString("Drive3:", "3: Traction Wheels Down");

        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new ShiftToHighGearC());
        SmartDashboard.putString("Drive6:", "6: Shift to High Gear");
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new ShiftToLowGearC());
        SmartDashboard.putString("Drive4:", "4: Shift to Low Gear");
        
        shootMedium = new JoystickButton(buttonJoystick, 5);
        shootMedium.whenPressed(new ShootAndRecockCG(200));
        SmartDashboard.putString("Monkey5:", "5: Shoot Medium");

        shootWeak = new JoystickButton(buttonJoystick, 3);
        shootWeak.whenPressed(new ShootAndRecockCG(400));
        SmartDashboard.putString("Monkey3:", "3: 1 pt Shot");

        hammer = new JoystickButton(buttonJoystick, 2);
        hammer.whenPressed(new HammerFireCG());
        SmartDashboard.putString("Monkey2:", "2: hammer");
        
        footDown = new JoystickButton(buttonJoystick, 4);
        footDown.whenPressed(new FootDownC());
        SmartDashboard.putString("Monkey4:", "4: foot Down");
        
        footUp = new JoystickButton(buttonJoystick, 6);
        footUp.whenPressed(new FootUpC());
        SmartDashboard.putString("Monkey6:", "6: foot Up");
        
        
        SmartDashboard.putData("loadBall", new LoadBallC());
        SmartDashboard.putData("FootDown", new FootDownC());
        SmartDashboard.putData("FootUp", new FootUpC());
        SmartDashboard.putData("HammerRetract", new HammerRetractC());
        SmartDashboard.putData("HammerExtendC", new HammerExtendC());
        SmartDashboard.putData("LoadingArmDown", new LoadingArmDownC());
        SmartDashboard.putData("LoadingArmUp", new LoadingArmUpC());
        SmartDashboard.putData("ShiftToLowGear", new ShiftToLowGearC());
        SmartDashboard.putData("ShiftToHighGear", new ShiftToHighGearC());
        SmartDashboard.putData("TractionWheelsUp", new TractionWheelsUpC());
        SmartDashboard.putData("TractionWheelsDown", new TractionWheelsDownC());
        SmartDashboard.putData("ShooterLatchOpen", new ShooterLatchOpenC());
        SmartDashboard.putData("ShooterLatchClose", new ShooterLatchCloseC());
        SmartDashboard.putData("WindWinch_0", new WindWinchC(0));
       //SmartDashboard.putData("WindWinch_30", new WindWinchC(30));
        //SmartDashboard.putData("WindWinch_60", new WindWinchC(60));
        SmartDashboard.putData("TightenWinch", new WinchTightenC());
        SmartDashboard.putData("LoosenWinch", new WinchLoosenC());
        SmartDashboard.putData("Automiss", new DriveForwardTimeC(.5));
        /*SmartDashboard.putData("WindWinch_120", new WindWinchC(120));
        SmartDashboard.putData("WindWinch_360", new WindWinchC(360));
        SmartDashboard.putData("WindWinch_500", new WindWinchC(500));
        */
        //SmartDashboard.putData("WindWinch_-50", new WindWinchC(-50));
        SmartDashboard.putData("ResetWinchEncoder", new ResetWinchEncoderC());
        SmartDashboard.putData("LoosenWinchAndLatch", new LoosenWinchAndLatchC());
        SmartDashboard.putData("ShootAndRecockCG", new ShootAndRecockCG(0));
       /* SmartDashboard.putData("DriveBasedOnEncodersC(2000,2000)", new DriveBasedOnEncodersC(2000,2000));
        SmartDashboard.putData("DriveBasedOnEncodersC(20000,0)", new DriveBasedOnEncodersC(20000,0));
        SmartDashboard.putData("DriveBasedOnEncodersC(0,-20000)", new DriveBasedOnEncodersC(0,-20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-20000,-20000)", new DriveBasedOnEncodersC(-20000,-20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(10000,20000)", new DriveBasedOnEncodersC(10000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(20000,20000)", new DriveBasedOnEncodersC(20000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-6000,20000)", new DriveBasedOnEncodersC(-6000,20000));
        SmartDashboard.putData("DriveBasedOnEncodersC(-20000,20000)", new DriveBasedOnEncodersC(-20000,20000));
        
    */
        SmartDashboard.putData("Bob: ", new Bob());
        
        System.out.println("OI constructor end");
    }
    
    public Joystick getDriveJoystick() 
    {
	return driveJoystick;
    }
    
    public Joystick getTurnJoystick() 
    {
	return buttonJoystick;
    }
    public void disableButtons()
    {
        loadBall.whenPressed(new TimeWaitC(0));
        System.out.println("Buttons Disable");
    }
    public void enableButtons()
    {
        loadBall.whileHeld(new LoadBallC());
        System.out.println("Buttons Enabled");
    }
}

