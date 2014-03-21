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
import team3663.neon.commands.WinchLoosenC;
import team3663.neon.commands.WinchTightenC;
import team3663.neon.commands.WindAndLatchToFullPowerCG;
import team3663.neon.commands.WindWinchC;


public class OI 
{
    private final Joystick driveJoystick;
    private final Joystick buttonJoystick;
    private final Joystick diagJoystick;

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
    public OI()
    {
        System.out.println("OI constructor start");

        driveJoystick = new Joystick(1);
        buttonJoystick = new Joystick(2);
        diagJoystick = new Joystick(3);
        
        //SmartDashboard.putString("DriveLabel", "DriveStick\nplus 2nd line\nplus 3rd line");
        //SmartDashboard.putString("MonkeyLabel", "ButtonMonkeyStick");
        
        heldTractionWheels = new JoystickButton(driveJoystick, 1);
        heldTractionWheels.whileHeld(new TractionWheelsDownC());
        //SmartDashboard.putString("Driver1:", "1: Hold Traction Down");
        
        loadBall = new JoystickButton(driveJoystick, 2);
        loadBall.whileHeld(new LoadBallC());
        //SmartDashboard.putString("Drive2:", "2: pickUp arm down");
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 3);
        changeToArcadeDrive.whenPressed(new TractionWheelsDownC());
        //SmartDashboard.putString("Drive3:", "3: Traction Wheels Down");
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new ShiftToLowGearC());
        //SmartDashboard.putString("Drive4:", "4: Shift to Low Gear");
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 5);
        changeToMecanumDrive.whenPressed(new TractionWheelsUpC());
        //SmartDashboard.putString("Drive5:", "5: Traction Wheels Up");
        
        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new ShiftToHighGearC());
        //SmartDashboard.putString("Drive6:", "6: Shift to High Gear");
        
        resetWinchEncoder = new JoystickButton(driveJoystick, 8);
        resetWinchEncoder.whenPressed(new ResetWinchEncoderC());
        
        LoosenWinchAndLatch = new JoystickButton(driveJoystick, 9);
        LoosenWinchAndLatch.whenPressed(new WindAndLatchToFullPowerCG());
        //SmartDashboard.putString("Drive9:", "9: Loosen Winch & Latch");
        
        winchEncoderZero = new JoystickButton(driveJoystick, 10);
        winchEncoderZero.whenPressed(new WindWinchC(0));
        //SmartDashboard.putString("Drive10:", "10: windWinch to 0");
        
        tightenWinch = new JoystickButton(driveJoystick, 12);
        tightenWinch.whileHeld(new WinchTightenC());
        //SmartDashboard.putString("Drive12:", "12: Tighten Winch");
        
        loosenWinch = new JoystickButton(driveJoystick, 11);
        loosenWinch.whileHeld(new WinchLoosenC());
        //SmartDashboard.putString("Drive11:", "11: Loosen Winch");
        

        shoot = new JoystickButton(buttonJoystick, 1);
        shoot.whenPressed(new ShootAndRecockCG(0));
        //SmartDashboard.putString("Monkey1:", "1: SHOOT!");
        
        hammer = new JoystickButton(buttonJoystick, 2);
        hammer.whenPressed(new HammerFireCG());
        //SmartDashboard.putString("Monkey2:", "2: hammer");
        
        shootWeak = new JoystickButton(buttonJoystick, 3);
        shootWeak.whenPressed(new ShootAndRecockCG(200));
        //SmartDashboard.putString("Monkey3:", "3: 1 pt Shot");
        
        footDown = new JoystickButton(buttonJoystick, 4);
        footDown.whenPressed(new FootDownC());
        //SmartDashboard.putString("Monkey4:", "4: foot Down");
        
        shootMedium = new JoystickButton(buttonJoystick, 5);
        shootMedium.whenPressed(new ShootAndRecockCG(100));
        //SmartDashboard.putString("Monkey5:", "5: Shoot Medium");

        footUp = new JoystickButton(buttonJoystick, 6);
        footUp.whenPressed(new FootUpC());
        //SmartDashboard.putString("Monkey6:", "6: foot Up");
        
        windWinchToFull = new JoystickButton(buttonJoystick, 12);
        windWinchToFull.whenPressed(new WindAndLatchToFullPowerCG());
        
        tractionWheelsDown = new JoystickButton(diagJoystick, 1);
        tractionWheelsDown.whenPressed(new TractionWheelsDownC());
        //SmartDashboard.putString("diag1:", "1: tractionWheelsDown");
        
        tractionWheelsUp = new JoystickButton(diagJoystick, 2);
        tractionWheelsUp.whenPressed(new TractionWheelsUpC());
        //SmartDashboard.putString("diag2:", "2: tractionWheelsUp");
        
        shooterLatchOpen = new JoystickButton(diagJoystick, 3);
        shooterLatchOpen.whenPressed(new LatchOpenC());
        //SmartDashboard.putString("diag3:", "3: ShooterLatchOpen");
        
        shooterLatchClose = new JoystickButton(diagJoystick, 4);
        shooterLatchClose.whenPressed(new LatchCloseC());
        //SmartDashboard.putString("diag4:", "4: ShooterLatchClose");
        
        hammerRetract = new JoystickButton(diagJoystick, 5);
        hammerRetract.whenPressed(new HammerRetractC());
        //SmartDashboard.putString("diag5:", "5: hammerRetract");
        
        hammerExtend = new JoystickButton(diagJoystick, 6);
        hammerExtend.whenPressed(new HammerExtendC());
        //SmartDashboard.putString("diag6:", "6: hammerExtend");
        
        /*motorTest_LeftFront = new JoystickButton(diagJoystick, 7);
        motorTest_LeftFront.whileHeld(new DriveMotorTestC(3,10000,.5));
        SmartDashboard.putString("diag7:", "7: spin left front drive motor");
        
        motorTest_RightFront = new JoystickButton(diagJoystick, 8);
        motorTest_RightFront.whileHeld(new DriveMotorTestC(4,10000,-.5));
        SmartDashboard.putString("diag8:", "8: spin right front drive motor");
        
        motorTest_RightBack = new JoystickButton(diagJoystick, 9);
        motorTest_RightBack.whileHeld(new DriveMotorTestC(2,10000,-.5));
        SmartDashboard.putString("diag9:", "9: spin right back drive motor");
        
        motorTest_LeftBack = new JoystickButton(diagJoystick, 10);
        motorTest_LeftBack.whileHeld(new DriveMotorTestC(1,10000,.5));
        SmartDashboard.putString("diag10:", "10: spin left back drive motor");*/
        
        moveAllTheMotors = new JoystickButton(diagJoystick, 7);
        
        testAllThings = new JoystickButton(diagJoystick, 8);
        testAllThings.whenPressed(new TestAllPartsOfTheRobotCG());
        
        spinLoadingArmMotorIntake = new JoystickButton(diagJoystick, 11);
        spinLoadingArmMotorIntake.whileHeld(new SpinLoadingArmMotorC(true,10000));
        //SmartDashboard.putString("diag11:", "11: spinLoadingArmMotorIntake");
        
        spinLoadingArmMotorEject = new JoystickButton(diagJoystick, 12);
        spinLoadingArmMotorEject.whileHeld(new SpinLoadingArmMotorC(false,10000));
        //SmartDashboard.putString("diag12:", "12: spinLoadingArmMotorEject");
        
        
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
        SmartDashboard.putData("DriveForwardTime_70", new DriveForwardTimeC(.7));
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
    public void weakButtonPressedOnce(boolean buttonWasPressed)
    {
        if(buttonWasPressed)
        {
            shootWeak.whenPressed(new ShootAndRecockCG(200));
        }
        else
        {
            shootWeak.whenPressed(new WindWinchC(200));
        }
    }
    public void mediumButtonPressedOnce(boolean buttonWasPressed)
    {
        if(buttonWasPressed)
        {
            shootMedium.whenPressed(new ShootAndRecockCG(100));
        }
        else
        {
            shootMedium.whenPressed(new WindWinchC(100));
        }
    }
    public void fullButtonPressedOnce(boolean buttonWasPressed)
    {
        if(buttonWasPressed)
        {
            shoot.whenPressed(new ShootAndRecockCG(0));
        }
        else
        {
            shoot.whenPressed(new WindWinchC(0));
        }
    }
}

