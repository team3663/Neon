package team3663.neon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team3663.neon.commands.HitBallCommand;
import team3663.neon.commands.LaunchBallCommand;
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
        
        shoot = new JoystickButton(driveJoystick, 7);
        shoot.whenPressed(new LaunchBallCommand());
        
        recock = new JoystickButton(driveJoystick, 2);
        recock.whenPressed(new RecockFlipapultCommand());
        
        changeToMecanumDrive = new JoystickButton(driveJoystick, 3);
        changeToMecanumDrive.whenPressed(new SwitchToMecanumDriveCommand());
        
        changeToArcadeDrive = new JoystickButton(driveJoystick, 5);
        changeToArcadeDrive.whenPressed(new SwitchToArcadeDriveCommand());
        
        switchToLowGear = new JoystickButton(driveJoystick, 4);
        switchToLowGear.whenPressed(new SwitchToLowGear());
        
        switchToHighGear = new JoystickButton(driveJoystick, 6);
        switchToHighGear.whenPressed(new SwitchToHighGear());
        
        pickUp = new JoystickButton(driveJoystick, 11);//Toggles Pickup arm
        pickUp.whenPressed(new TogglePickUpArmCommand());
        
        hammer = new JoystickButton(driveJoystick, 12);
        hammer.whenPressed(new HitBallCommand());
        
        foot = new JoystickButton(driveJoystick, 10);
        foot.whenPressed(new ToggleFootCommand());
        
        imageOn = new JoystickButton(driveJoystick, 1);
        imageOn.whenPressed(new TargetCommand());
        
        //latch1 off and 2 on for closed latch
        //hammer is load arm
        //foot up = 2 on and 1oof
        //neg inwards for pickup wheel
        /*
        hammer = new JoystickButton(driveJoystick, 7);
        hammer.whenPressed(new ChangeHammerSolenoid());
        
        pickUp = new JoystickButton(driveJoystick, 8);
        pickUp.whenPressed(new ChangePickUpSolenoid());
        
        shoot = new JoystickButton(driveJoystick, 9);
        shoot.whenPressed(new ChangeShooterLatchSolenoid());
        
        foot = new JoystickButton(driveJoystick, 10);
        foot.whenPressed(new ChangeFootSolenoid());
*/
    }
    
    /*public Joystick getTurnJoystick()
    {
        return turnJoystick;
    }*/
    
    public Joystick getDriveJoystick() 
    {
	return driveJoystick;
    }
    
    public Joystick getTurnJoystick() 
    {
	return turnJoystick;
    }
    public JoystickButton getPickUpButton()
    {
        return pickUp;
    }
}

