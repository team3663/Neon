package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.Bob;
import team3663.neon.commands.CG_Autonomous2;
import team3663.neon.commands.C_DriveForwardTime;
import team3663.neon.commands.C_DriveMotorTest;
import team3663.neon.commands.CG_FireAfterBackUp;
import team3663.neon.commands.CG_FireWithArmUp;
import team3663.neon.commands.P_HammerRetract;
import team3663.neon.commands.P_TractionWheelsDown;
import team3663.neon.commands.P_ShiftToHighGear;
import team3663.neon.commands.P_ShiftToLowGear;
import team3663.neon.commands.P_TractionWheelsUp;
import team3663.neon.commands.P_FootDown;
import team3663.neon.commands.P_FootUp;
import team3663.neon.commands.P_HammerExtend;
import team3663.neon.commands.CG_HammerFireAfterDriveForward;
import team3663.neon.commands.CG_HammerFire;
import team3663.neon.commands.C_LoadBall;
import team3663.neon.commands.P_LoadingArmDown;
import team3663.neon.commands.P_LoadingArmUp;
import team3663.neon.commands.C_LoosenWinchAndLatch;
import team3663.neon.commands.P_ResetWinchEncoder;
import team3663.neon.commands.CG_ShootAndRecock;
import team3663.neon.commands.P_LatchClose;
import team3663.neon.commands.P_LatchOpen;
import team3663.neon.commands.C_SpinLoadingArmMotor;
import team3663.neon.commands.CG_TestAllPartsOfTheRobot;
import team3663.neon.commands.CG_TractionDownLowGear;
import team3663.neon.commands.CG_TractionWheelsUpHighGear;
import team3663.neon.commands.P_WinchLoosen;
import team3663.neon.commands.P_WinchTighten;
import team3663.neon.commands.CG_WindAndLatchToFullPower;
import team3663.neon.commands.C_WindWinch;
import team3663.neon.commands.P_ResetBothDriveEncoders;


public class OI 
{
    private final Joystick driveJoystick;
    private final Joystick buttonJoystick;

    private static JoystickButton changeToArcadeDrive;
    private static JoystickButton changeToMecanumDrive;
    private static JoystickButton hammer;
    private static JoystickButton loadBall;
    private static JoystickButton shoot;
    private static JoystickButton shootMedium;
    private static JoystickButton footUp;
    private static JoystickButton footDown;
    private static JoystickButton loosenWinch;
    private static JoystickButton tightenWinch;
    private static JoystickButton windWinchToFull;
    private static JoystickButton resetWinchEncoder;
    private static JoystickButton fireHammerAfterBackUp;
    private static JoystickButton relatchAndRewind;
    private static JoystickButton fireWithArmUp;
    private static JoystickButton fireFromWall;
    private static JoystickButton fireFromGoal;
    public OI()
    {
        System.out.println("OI constructor start");

        driveJoystick = new Joystick(1);
        buttonJoystick = new Joystick(2);
        
        shoot = new JoystickButton(driveJoystick, 1);
        shoot.whenPressed(new CG_ShootAndRecock(0));
        
        loadBall = new JoystickButton(driveJoystick, 2);
        loadBall.whileHeld(new C_LoadBall());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 3);
        changeToArcadeDrive.whenPressed(new CG_TractionDownLowGear());
        
        fireWithArmUp = new JoystickButton(driveJoystick, 4);
        fireWithArmUp.whenPressed(new CG_FireWithArmUp(175));
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 5);
        changeToMecanumDrive.whenPressed(new CG_TractionWheelsUpHighGear());
        
        shootMedium = new JoystickButton(driveJoystick, 6);
        shootMedium.whenPressed(new CG_ShootAndRecock(100));
        
        fireFromGoal = new JoystickButton(driveJoystick, 9);
        fireFromGoal.whenPressed(new CG_FireAfterBackUp(0, .5, .9));
        
        fireFromWall = new JoystickButton(driveJoystick, 10);
        fireFromWall.whenPressed(new CG_FireAfterBackUp(0, 1, .9));
        
        fireHammerAfterBackUp = new JoystickButton(driveJoystick, 11);
        fireHammerAfterBackUp.whenPressed(new CG_HammerFireAfterDriveForward());
        
        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new CG_HammerFire());
        
        relatchAndRewind = new JoystickButton(buttonJoystick, 3);
        relatchAndRewind.whenPressed(new CG_WindAndLatchToFullPower());
        
        footDown = new JoystickButton(buttonJoystick, 4);
        footDown.whenPressed(new P_FootDown());
        
        windWinchToFull = new JoystickButton(buttonJoystick, 5);
        windWinchToFull.whenPressed(new C_WindWinch(0));

        footUp = new JoystickButton(buttonJoystick, 6);
        footUp.whenPressed(new P_FootUp());
        
        resetWinchEncoder = new JoystickButton(buttonJoystick, 7);
        resetWinchEncoder.whenPressed(new P_ResetWinchEncoder());
        
        tightenWinch = new JoystickButton(buttonJoystick, 8);
        tightenWinch.whenPressed(new P_WinchTighten());
        
        loosenWinch = new JoystickButton(buttonJoystick, 9);
        loosenWinch.whenPressed(new P_WinchLoosen());
        
        SmartDashboard.putData("Autonomous2", new CG_Autonomous2());
        SmartDashboard.putData("bob", new Bob());
        SmartDashboard.putData("loadBall", new C_LoadBall());
        SmartDashboard.putData("FootDown", new P_FootDown());
        SmartDashboard.putData("FootUp", new P_FootUp());
        SmartDashboard.putData("HammerRetract", new P_HammerRetract());
        SmartDashboard.putData("HammerExtendC", new P_HammerExtend());
        SmartDashboard.putData("LoadingArmDown", new P_LoadingArmDown());
        SmartDashboard.putData("LoadingArmUp", new P_LoadingArmUp());
        SmartDashboard.putData("ShiftToLowGear", new P_ShiftToLowGear());
        SmartDashboard.putData("ShiftToHighGear", new P_ShiftToHighGear());
        SmartDashboard.putData("TractionWheelsUp", new P_TractionWheelsUp());
        SmartDashboard.putData("TractionWheelsDown", new P_TractionWheelsDown());
        SmartDashboard.putData("LatchOpen", new P_LatchOpen());
        SmartDashboard.putData("LatchClose", new P_LatchClose());
        SmartDashboard.putData("TightenWinch", new P_WinchTighten());
        SmartDashboard.putData("LoosenWinch", new P_WinchLoosen());
        SmartDashboard.putData("WindWinch_0", new C_WindWinch(0));
        SmartDashboard.putData("SpinLoadingArmMotorC_Intake", new C_SpinLoadingArmMotor(true,10000));
        SmartDashboard.putData("SpinLoadingArmMotorC_Eject", new C_SpinLoadingArmMotor(false,10000));
        SmartDashboard.putData("DriveMotorTestC_LeftBack", new C_DriveMotorTest(1,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_LeftFront", new C_DriveMotorTest(3,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_RightFront", new C_DriveMotorTest(4,10000,.5));
        SmartDashboard.putData("DriveMotorTestC_RightBack", new C_DriveMotorTest(2,10000,.5));
        
        SmartDashboard.putData("ResetBothDriveEncoders", new P_ResetBothDriveEncoders());
        SmartDashboard.putData("TestAllThingsOfTheRobot", new CG_TestAllPartsOfTheRobot());
        SmartDashboard.putData("DriveForwardTime_70", new C_DriveForwardTime(.7, -1));
        SmartDashboard.putData("ResetWinchEncoder", new P_ResetWinchEncoder());
        SmartDashboard.putData("LoosenWinchAndLatch", new C_LoosenWinchAndLatch());
        SmartDashboard.putData("ShootAndRecockCG", new CG_ShootAndRecock(0));

        
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

