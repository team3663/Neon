package team3663.neon;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    public static RobotDrive driveTrainRobotDrive3663;
    
    public static Relay pneumaticsCompressorSwitch;
    public static Relay lightsledRelay;
    
    public static SpeedController driveTrainSpeedControllerFrontLeft;
    public static SpeedController driveTrainSpeedControllerBackLeft;
    public static SpeedController driveTrainSpeedControllerFrontRight;
    public static SpeedController driveTrainSpeedControllerBackRight;
    public static SpeedController pickUpSpeedController;
    public static SpeedController shooterSpeedController;
    
    public static Encoder shooterEncoder;
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    
    public static Solenoid driveTrainGearShift1;
    public static Solenoid driveTrainGearShift2;
    public static Solenoid driveTrainDriveChange1;
    public static Solenoid driveTrainDriveChange2;
    public static Solenoid pickUpSolenoid1;
    public static Solenoid pickUpSolenoid2;
    public static Solenoid shooterLatchSolenoid1;
    public static Solenoid shooterLatchSolenoid2;
    public static Solenoid hammerSolenoid1;
    public static Solenoid hammerSolenoid2;
    public static Solenoid footSolenoid1;
    public static Solenoid footSolenoid2;
    
    public static DigitalInput shooterLimitSwitch;
    public static DigitalInput ballLimitSwitch;
    public static DigitalInput pneumaticsCompressorLimitSwitch;
    public static DigitalInput photoelectricGroundSensor;

    public static AnalogChannel rangeFinderFrontUltrasonic;
    public static AnalogChannel rangeFinderBackUltrasonic;
    public static AnalogChannel rangeFinderLeftUltrasonic;
    public static AnalogChannel rangeFinderRightUltrasonic;
    
    public static AxisCamera camera;          // the axis camera object (connected to the switch)
    
    public static void init()
    {
        LiveWindow lw = new LiveWindow(); //May need to be changed because we dont have getInstance()
        
        
        //camera = AxisCamera.getInstance("10.36.63.100");  // get an instance of the camera
        
        // All of the driveTrain sensors and items----------------------------------
        driveTrainSpeedControllerFrontLeft = new Victor(PortMap.MainModulePort, PortMap.driveTrainSpeedControllerFrontLeftPort);
        driveTrainSpeedControllerBackLeft = new Victor(PortMap.MainModulePort, PortMap.driveTrainSpeedControllerBackLeftPort);
        driveTrainSpeedControllerFrontRight = new Victor(PortMap.MainModulePort, PortMap.driveTrainSpeedControllerFrontRightPort);
        driveTrainSpeedControllerBackRight = new Victor(PortMap.MainModulePort, PortMap.driveTrainSpeedControllerBackRightPort);
        
        driveTrainRobotDrive3663 = new RobotDrive(driveTrainSpeedControllerFrontLeft, driveTrainSpeedControllerBackLeft,
                                                  driveTrainSpeedControllerFrontRight, driveTrainSpeedControllerBackRight);
      
        driveTrainRobotDrive3663.setSafetyEnabled(false);
        driveTrainRobotDrive3663.setExpiration(0.1);
        driveTrainRobotDrive3663.setSensitivity(0.5);
        driveTrainRobotDrive3663.setMaxOutput(1.0);
        driveTrainRobotDrive3663.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive3663.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        driveTrainLeftEncoder = new Encoder(PortMap.MainModulePort, PortMap.driveTrainLeftEncoderport1,
                                            PortMap.MainModulePort, PortMap.driveTrainLeftEncoderport2, false, CounterBase.EncodingType.k4X);
       
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveTrainLeftEncoder.start();
            
        driveTrainRightEncoder = new Encoder(PortMap.MainModulePort, PortMap.driveTrainRightEncoderport1,
                                             PortMap.MainModulePort, PortMap.driveTrainRightEncoderport2, false, CounterBase.EncodingType.k4X);
        
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveTrainRightEncoder.start();    
        
        driveTrainGearShift1 = new Solenoid(PortMap.MainModulePort,PortMap.driveTrainGearShift1port);
        driveTrainGearShift2 = new Solenoid(PortMap.MainModulePort, PortMap.driveTrainGearShift2port);

        driveTrainDriveChange1 = new Solenoid(PortMap.MainModulePort, PortMap.driveTrainDriveChange1port);
        driveTrainDriveChange2 = new Solenoid(PortMap.MainModulePort, PortMap.driveTrainDriveChange2port);
        
        //End of driveTrain sensors and items------------------------------------------------------------------
        
        //Components relating to current game(2014) Shooter items Start----------------------------------------
        
        pickUpSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.pickUpSolenoidPort1);
        pickUpSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.pickUpsolenoidPort2);
        
        hammerSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.hammerSolenoidPort1);
        hammerSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.hammerSolenoidPort2);
        
        footSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footSolenoidPort1);
        footSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footSolenoidPort2);
        
        shooterLatchSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoidPort1);
        shooterLatchSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoidPort2);
        
        shooterSpeedController = new Victor(PortMap.MainModulePort, PortMap.shooterSpeedControllerPort);
        
        shooterEncoder = new Encoder(PortMap.MainModulePort, PortMap.shooterEncoderPort1, 
                                     PortMap.MainModulePort, PortMap.shooterEncoderPort2);
        
        shooterEncoder.setDistancePerPulse(1.0);
        shooterEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        shooterEncoder.start();
        
        pickUpSpeedController = new Victor(PortMap.MainModulePort, PortMap.pickUpSpeedControllerPort); 
        shooterLimitSwitch = new DigitalInput(PortMap.MainModulePort, PortMap.shooterLimitSwitchPort);
        
        ballLimitSwitch = new DigitalInput(PortMap.MainModulePort, PortMap.ballLimitSwitchPort);
        
        //Components relating to current game(2014) Shooter items END----------------------------------------
        
        //Comonents that are used generally throughout most games Start--------------------------------------
        
        pneumaticsCompressorSwitch = new Relay(PortMap.MainModulePort, PortMap.pneumaticsCompressorSwitchPort);
        pneumaticsCompressorLimitSwitch = new DigitalInput(PortMap.MainModulePort, PortMap.pneumaticsCompressorLimitSwitchPort);
        
        photoelectricGroundSensor = new DigitalInput(PortMap.MainModulePort, PortMap.photoelectricGroundSensorPort);
        
        //lightsledRelay = new Relay(PortMap.MainModulePort,PortMap.lightsledRelayPort);
       
        rangeFinderFrontUltrasonic = new AnalogChannel(PortMap.MainModulePort, PortMap.rangeFinderFrontUltrasonicPort);
        //rangeFinderRightUltrasonic = new AnalogChannel(PortMap.MainModulePort, PortMap.rangeFinderRightUltrasonicPort);
       
        //Components that are used generally thouhtout most games END-----------------------------------------
       
        //All LiveWindow actuators add here
        LiveWindow.addActuator("VICTORS", "SpeedControllerFrontLeft", (Victor)driveTrainSpeedControllerFrontLeft);
        LiveWindow.addActuator("VICTORS", "SpeedControllerBackLeft", (Victor)driveTrainSpeedControllerBackLeft);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerFrontRight",(Victor)driveTrainSpeedControllerFrontRight);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerBackRight",(Victor)driveTrainSpeedControllerBackRight);
        LiveWindow.addActuator("VICTORS", "Pick up wheels", (Victor)pickUpSpeedController);
        LiveWindow.addActuator("VICTORS", "Winch Motor", (Victor)shooterSpeedController);
        
        LiveWindow.addSensor("ENCODERS", "LeftEncoder", driveTrainLeftEncoder);
        LiveWindow.addSensor("ENCODERS", "RightEncoder", driveTrainRightEncoder);
        LiveWindow.addSensor("ENCODERS", "Shooter Encoder", shooterEncoder);
        
        LiveWindow.addActuator("PNEUMATICS", "CompressorSwitch", pneumaticsCompressorSwitch);
        LiveWindow.addSensor("PNEUMATICS", "CompressorLimitSwitch", pneumaticsCompressorLimitSwitch);
        
        LiveWindow.addActuator("SOLENOIDS", "GearShift1", driveTrainGearShift1);
        LiveWindow.addActuator("SOLENOIDS", "GearShift2", driveTrainGearShift2);
        LiveWindow.addActuator("SOLENOIDS", "Hammer1", hammerSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Hammer2", hammerSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Foot1", footSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Foot2", footSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Latch1", shooterLatchSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Latch2", shooterLatchSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade1", driveTrainDriveChange1);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade2", driveTrainDriveChange2);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up1", pickUpSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up2", pickUpSolenoid2);
        
        LiveWindow.addSensor("LIMIT SWITCHES", "BallLimitSwitch", ballLimitSwitch);
        LiveWindow.addSensor("LIMIT SWITCHES", "ShooterLimitSwitch", shooterLimitSwitch);
        LiveWindow.addSensor("LIMIT SWITCHES", "LimitSwitch", shooterLimitSwitch);
        /*LiveWindow.addSensor("RangeFinder", "BackUltrasonic", rangeFinderBackUltrasonic);
        LiveWindow.addSensor("RangeFinder", "RightUltrasonic", rangeFinderRightUltrasonic);
        LiveWindow.addSensor("RangeFinder", "FrontUltrasonic", rangeFinderFrontUltrasonic);
        LiveWindow.addSensor("RangeFinder", "LeftUltrasonic", rangeFinderLeftUltrasonic);
        
        LiveWindow.addActuator("Lights", "LedArray", lightsledRelay);
        LiveWindow.addSensor("Photoeletric", "GroundLineSensor", photoelectricGroundSensor);*/

    }
}
