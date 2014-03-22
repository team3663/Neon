package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.Autonomous2CG;
import team3663.neon.commands.Bob;
import team3663.neon.commands.DriveForwardTimeC;
import team3663.neon.commands.DriveMotorTestC;
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
import team3663.neon.commands.LatchCloseC;
import team3663.neon.commands.LatchOpenC;
import team3663.neon.commands.SpinLoadingArmMotorC;
import team3663.neon.commands.TestAllPartsOfTheRobotCG;
import team3663.neon.commands.TimeWaitC;
import team3663.neon.commands.TractionDownLowGearCG;
import team3663.neon.commands.TractionWheelsUpHighGearCG;
import team3663.neon.commands.WinchLoosenC;
import team3663.neon.commands.WinchTightenC;
import team3663.neon.commands.WindAndLatchToFullPowerCG;
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
    private static JoystickButton heldTractionWheels;
    private static JoystickButton tractionWheelsDown;
    private static JoystickButton tractionWheelsUp;
    private static JoystickButton shooterLatchOpen;
    private static JoystickButton shooterLatchClose;
    private static JoystickButton hammerRetract;
    private static JoystickButton hammerExtend;
    private static JoystickButton motorTest_LeftFront;
    private static JoystickButton motorTest_RightFront;
    private static JoystickButton motorTest_RightBack;
    private static JoystickButton motorTest_LeftBack;
    private static JoystickButton spinLoadingArmMotorIntake;
    private static JoystickButton spinLoadingArmMotorEject;
    private static JoystickButton windWinchToFull;
    private static JoystickButton moveAllTheMotors;
    private static JoystickButton testAllThings;
    private static JoystickButton resetWinchEncoder;
    private static JoystickButton fullFireAfterBackUp;
    private static JoystickButton fireHammerAfterBackUp;
    private static JoystickButton relatchAndRewind;
    public OI()
    {
        System.out.println("OI constructor start");

        driveJoystick = new Joystick(1);
        buttonJoystick = new Joystick(2);
        
        shoot = new JoystickButton(driveJoystick, 1);
        shoot.whenPressed(new ShootAndRecockCG(0));
        
        loadBall = new JoystickButton(driveJoystick, 2);
        loadBall.whileHeld(new LoadBallC());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 3);
        changeToArcadeDrive.whenPressed(new TractionDownLowGearCG());
        
        shootWeak = new JoystickButton(driveJoystick, 4);
        shootWeak.whenPressed(new ShootAndRecockCG(200));
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 5);
        changeToMecanumDrive.whenPressed(new TractionWheelsUpHighGearCG());
        
        shootMedium = new JoystickButton(driveJoystick, 6);
        shootMedium.whenPressed(new ShootAndRecockCG(100));
        
        //fullFireAfterBackUp = new JoystickButton(driveJoystick, 9);
        //fullFireAfterBackUp.whenPressed(new FullFireAfterBackUpC());
        
        //hammerFireAfterBackUp = new JoystickButton(driveJoystick, 11);
        //hammerFireAfterBackUp.whileHeld(new HammerFireAfterBackUpC());
        
        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new HammerFireCG());
        
        relatchAndRewind = new JoystickButton(buttonJoystick, 3);
        relatchAndRewind.whenPressed(new WindAndLatchToFullPowerCG());
        
        footDown = new JoystickButton(buttonJoystick, 4);
        footDown.whenPressed(new FootDownC());
        
        windWinchToFull = new JoystickButton(buttonJoystick, 5);
        windWinchToFull.whenPressed(new WindWinchC(0));

        footUp = new JoystickButton(buttonJoystick, 6);
        footUp.whenPressed(new FootUpC());
        
        
        SmartDashboard.putData("Autonomous2", new Autonomous2CG());
        SmartDashboard.putData("bob", new Bob());
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
        SmartDashboard.putData("LatchOpen", new LatchOpenC());
        SmartDashboard.putData("LatchClose", new LatchCloseC());
        SmartDashboard.putData("TightenWinch", new WinchTightenC());
        SmartDashboard.putData("LoosenWinch", new WinchLoosenC());
        SmartDashboard.putData("WindWinch_0", new WindWinchC(0));
        SmartDashboard.putData("SpinLoadingArmMotorC_Intake", new SpinLoadingArmMotorC(true,10000));
        SmartDashboard.putData("SpinLoadingArmMotorC_Eject", new SpinLoadingArmMotorC(false,10000));
        SmartDashboard.putData("DriveMotorTestC_LeftBack", new DriveMotorTestC(1,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_LeftFront", new DriveMotorTestC(3,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_RightFront", new DriveMotorTestC(4,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_RightBack", new DriveMotorTestC(2,10000,.5));
        
        
        SmartDashboard.putData("TestAllThingsOfTheRobot", new TestAllPartsOfTheRobotCG());
        SmartDashboard.putData("DriveForwardTime_70", new DriveForwardTimeC(.7, -1));
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
}

