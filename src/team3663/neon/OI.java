package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3663.neon.commands.Bob;
import team3663.neon.commands.RetractHammerCommand;
import team3663.neon.commands.Karel;
import team3663.neon.commands.RecockFlipapultCommand;
import team3663.neon.commands.SwitchToArcadeDriveCommand;
import team3663.neon.commands.SwitchToHighGear;
import team3663.neon.commands.SwitchToLowGear;
import team3663.neon.commands.SwitchToMecanumDriveCommand;
import team3663.neon.commands.TargetCommand;
import team3663.neon.commands.ToggleFootCommand;
import team3663.neon.commands.TogglePickUpArmCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    private final Joystick driveJoystick;
    private final Joystick turnJoystick;
    //private final Joystick turnJoystick;
    private static JoystickButton changeToArcadeDrive;
    private static JoystickButton changeToMecanumDrive;
    private static JoystickButton switchToHighGear;
    private static JoystickButton switchToLowGear;
    private static JoystickButton pickUp;
    private static JoystickButton shoot;
    private static JoystickButton recock;
    private static JoystickButton hammer;
    private static JoystickButton imageOn;
    private static JoystickButton foot;
    
    private static JoystickButton switchLiveWindowStatus;
    
    private static JoystickButton goBob;
/*
    private static JoystickButton goBob2;
    private static JoystickButton goBob3;
    private static JoystickButton goBob4;
    private static JoystickButton goBob5;
    private static JoystickButton goBob6;
    private static JoystickButton goBob7;
    private static JoystickButton goBob8;
    private static JoystickButton goBob9;
    private static JoystickButton goBob10;
    private static JoystickButton goBob11;
    private static JoystickButton goBob12;
*/
    private static JoystickButton goKarel;
    private static JoystickButton goBobNKarel;
    
    
    //private Button gearShift = new JoystickButton(driveJoystick, 3);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public OI()
    {
        driveJoystick = new Joystick(1);
        turnJoystick = new Joystick(2);
        
        imageOn = new JoystickButton(driveJoystick, 1);
        imageOn.whenPressed(new TargetCommand());
        
        recock = new JoystickButton(driveJoystick, 2);
        recock.whenPressed(new RecockFlipapultCommand());
        SmartDashboard.putData("RecockFlipapultCommand", new RecockFlipapultCommand());
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 3);
        changeToMecanumDrive.whenPressed(new SwitchToMecanumDriveCommand());
        SmartDashboard.putData("SwitchToMecanumDriveCommand", new SwitchToMecanumDriveCommand());
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new SwitchToLowGear());
        SmartDashboard.putData("SwitchToLowGear", new SwitchToLowGear());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 5);
        changeToArcadeDrive.whenPressed(new SwitchToArcadeDriveCommand());
        SmartDashboard.putData("SwitchToArcadeDriveCommand", new SwitchToArcadeDriveCommand());
        
        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new SwitchToHighGear());
        SmartDashboard.putData("SwitchToHighGear", new SwitchToHighGear());
        
        //shoot = new JoystickButton(driveJoystick, 7);
        //shoot.whenPressed(new LaunchBallCommand());
        //SmartDashboard.putData("LaunchBallCommand", new LaunchBallCommand());

        goBob = new JoystickButton(driveJoystick, 7);
        goBob.whenPressed(new Bob());
        SmartDashboard.putData("Bob", new Bob());

        //goBobNKarel = new JoystickButton(driveJoystick, 8);
        //goBobNKarel.whenPressed(new BobNKarel());
        //SmartDashboard.putData("BobNKarel", new BobNKarel());
        
        goKarel = new JoystickButton(driveJoystick, 9);
        goKarel.whenPressed(new Karel());
        SmartDashboard.putData("Karel", new Karel());
        
        foot = new JoystickButton(driveJoystick, 10);
        foot.whenPressed(new ToggleFootCommand());
        SmartDashboard.putData("ToggleFootCommand", new ToggleFootCommand());
        
        pickUp = new JoystickButton(driveJoystick, 11);//Toggles Pickup arm
        pickUp.whenPressed(new TogglePickUpArmCommand());
        SmartDashboard.putData("TogglePickUpArmCommand", new TogglePickUpArmCommand());
        
        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new RetractHammerCommand());
        SmartDashboard.putData("RetractHammerCommand", new RetractHammerCommand());
/* 
        goBob2 = new JoystickButton(driveJoystick, 2);
        goBob2.cancelWhenActive(new Bob());
        goBob3 = new JoystickButton(driveJoystick, 3);
        goBob3.toggleWhenActive(new Bob());
        goBob4 = new JoystickButton(driveJoystick, 4);
        goBob4.toggleWhenPressed(new Bob());
        goBob5 = new JoystickButton(driveJoystick, 5);
        goBob5.whenActive(new Bob());
        goBob6 = new JoystickButton(driveJoystick, 6);
        goBob6.whenInactive(new Bob());
        goBob7 = new JoystickButton(driveJoystick, 7);
        goBob7.whenReleased(new Bob());
        goBob8 = new JoystickButton(driveJoystick, 8);
        goBob8.whenPressed(new Bob());
        
        goBob9 = new JoystickButton(driveJoystick, 9);
        goBob9.whileActive(new Bob());
        goBob10 = new JoystickButton(driveJoystick, 10);
        goBob10.whileHeld(new Bob());
        goBob11 = new JoystickButton(driveJoystick, 11);
        goBob11.whileActive(new Bob());
        
        goBob12 = new JoystickButton(driveJoystick, 12);
        goBob12.whileHeld(new Bob());
*/
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

