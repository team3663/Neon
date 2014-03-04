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
    public static RobotDrive driveTrain;
    
    public static Relay compressorOnOffRelay;

    public static SpeedController driveTrainFrontLeftSpeedController;
    public static SpeedController driveTrainBackLeftSpeedController;
    public static SpeedController driveTrainFrontRightSpeedController;
    public static SpeedController driveTrainBackRightSpeedController;
    public static SpeedController LoadingArmSpeedController;
    public static SpeedController shooterWinchSpeedController;
    
    public static Encoder shooterEncoder;
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    
    public static Solenoid gearShiftHighLowSolenoid1;
    public static Solenoid gearShiftHighLowSolenoid2;
    public static Solenoid tractionWheelUpDownSolenoid1;
    public static Solenoid tractionWheelUpDownSolenoid2;
    public static Solenoid loadingArmUpDownSolenoid1;
    public static Solenoid loadingArmUpDownSolenoid2;
    public static Solenoid shooterLatchSolenoid1;
    public static Solenoid shooterLatchSolenoid2;
    public static Solenoid hammerRetractExtendSolenoid1;
    public static Solenoid hammerRetractExtendSolenoid2;
    public static Solenoid footUpDownSolenoid1;
    public static Solenoid footUpDownSolenoid2;
    
    public static DigitalInput shooterLimitSwitchDIO;
    public static DigitalInput ballLoadedLimitSwitchDIO;
    public static DigitalInput compressorLimitSwitchDIO;
    
    public static AnalogChannel frontUltrasonicAnalog;
        
    public static void init()
    {
        System.out.println("RobotMap.init start");

        // All of the driveTrain sensors and items----------------------------------
        driveTrainFrontLeftSpeedController = new Victor(PortMap.MainModulePort, PortMap.driveTrainFrontLeftSpeedControllerPort);
        driveTrainBackLeftSpeedController = new Victor(PortMap.MainModulePort, PortMap.driveTrainBackLeftSpeedControllerPort);
        driveTrainFrontRightSpeedController = new Victor(PortMap.MainModulePort, PortMap.driveTrainFrontRightSpeedControllerPort);
        driveTrainBackRightSpeedController = new Victor(PortMap.MainModulePort, PortMap.driveTrainBackRightSpeedControllerPort);
        
        driveTrain = new RobotDrive(driveTrainFrontLeftSpeedController, driveTrainBackLeftSpeedController,
                                                  driveTrainFrontRightSpeedController, driveTrainBackRightSpeedController);
      
        driveTrain.setSafetyEnabled(false);
        driveTrain.setExpiration(0.1);
        driveTrain.setSensitivity(0.5);
        driveTrain.setMaxOutput(1.0);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        driveTrainLeftEncoder = new Encoder(PortMap.MainModulePort, PortMap.driveTrainLeftEncoder1Port,
                                            PortMap.MainModulePort, PortMap.driveTrainLeftEncoder2Port, false, CounterBase.EncodingType.k4X);
       
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveTrainLeftEncoder.start();
            
        driveTrainRightEncoder = new Encoder(PortMap.MainModulePort, PortMap.driveTrainRightEncoder1Port,
                                             PortMap.MainModulePort, PortMap.driveTrainRightEncoder2Port, false, CounterBase.EncodingType.k4X);
        
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveTrainRightEncoder.start();    
        if(Robot3663.mustard){
            gearShiftHighLowSolenoid1 = new Solenoid(PortMap.MainModulePort,PortMap.gearShiftHighLowSolenoid1Port);
            gearShiftHighLowSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.gearShiftHighLowSolenoid2Port);

            tractionWheelUpDownSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.tractionWheelUpDownSolenoid1Port);
            tractionWheelUpDownSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.tractionWheelUpDownSolenoid2Port);

            //End of driveTrain sensors and items------------------------------------------------------------------

            //Components relating to current game(2014) Shooter items Start----------------------------------------

            loadingArmUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.loadingArmUpDownSolenoid1Port);
            loadingArmUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.loadingArmUpDownSolenoid2Port);

            hammerRetractExtendSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.hammerRetractExtendSolenoid1Port);
            hammerRetractExtendSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.hammerRetractExtendSolenoid2Port);

            footUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid1Port);
            footUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid2Port);

            shooterLatchSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoid1Port);
            shooterLatchSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoid2Port);
        }
        else
        {
            gearShiftHighLowSolenoid1 = new Solenoid(PortMap.SecondaryModulePort,PortMap.gearShiftHighLowSolenoid1PortK);
            gearShiftHighLowSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.gearShiftHighLowSolenoid2PortK);

            tractionWheelUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.tractionWheelUpDownSolenoid1PortK);
            tractionWheelUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.tractionWheelUpDownSolenoid2PortK);

            //End of driveTrain sensors and items------------------------------------------------------------------

            //Components relating to current game(2014) Shooter items Start----------------------------------------

            loadingArmUpDownSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.loadingArmUpDownSolenoid1PortK);
            loadingArmUpDownSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.loadingArmUpDownSolenoid2PortK);

            hammerRetractExtendSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.hammerRetractExtendSolenoid1PortK);
            hammerRetractExtendSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.hammerRetractExtendSolenoid2PortK);

            footUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid1PortK);
            footUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid2PortK);

            shooterLatchSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoid1PortK);
            shooterLatchSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.shooterLatchSolenoid2PortK);
        }
        shooterWinchSpeedController = new Victor(PortMap.MainModulePort, PortMap.shooterWinchSpeedControllerPort);
        
        shooterEncoder = new Encoder(PortMap.MainModulePort, PortMap.shooterEncoderPort1, 
                                     PortMap.MainModulePort, PortMap.shooterEncoderPort2);
        
        shooterEncoder.setDistancePerPulse(1.0);
        shooterEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        shooterEncoder.start();
        
        LoadingArmSpeedController = new Victor(PortMap.MainModulePort, PortMap.LoadingArmSpeedControllerPort); 
        shooterLimitSwitchDIO = new DigitalInput(PortMap.MainModulePort, PortMap.shooterLimitSwitchDIOPort);
        
        ballLoadedLimitSwitchDIO = new DigitalInput(PortMap.MainModulePort, PortMap.ballLoadedLimitSwitchDIOPort);
        
        compressorOnOffRelay = new Relay(PortMap.MainModulePort, PortMap.compressorOnOffRelayPort);
        compressorLimitSwitchDIO = new DigitalInput(PortMap.MainModulePort, PortMap.compressorLimitSwitchDIOPort);
        
        frontUltrasonicAnalog = new AnalogChannel(PortMap.MainModulePort, PortMap.frontUltrasonicAnalogPort);
        
        //All LiveWindow actuators add here
        LiveWindow.addActuator("VICTORS", "SpeedControllerFrontLeft", (Victor)driveTrainFrontLeftSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeedControllerBackLeft", (Victor)driveTrainBackLeftSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerFrontRight",(Victor)driveTrainFrontRightSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerBackRight",(Victor)driveTrainBackRightSpeedController);
        LiveWindow.addActuator("VICTORS", "Pick up wheels", (Victor)LoadingArmSpeedController);
        LiveWindow.addActuator("VICTORS", "Winch Motor", (Victor)shooterWinchSpeedController);
        
        LiveWindow.addSensor("ENCODERS", "LeftEncoder", driveTrainLeftEncoder);
        LiveWindow.addSensor("ENCODERS", "RightEncoder", driveTrainRightEncoder);
        LiveWindow.addSensor("ENCODERS", "Shooter Encoder", shooterEncoder);
        
        LiveWindow.addActuator("PNEUMATICS", "CompressorOnOffRelay", compressorOnOffRelay);
        LiveWindow.addSensor("PNEUMATICS", "CompressorLimitSwitch", compressorLimitSwitchDIO);
        
        LiveWindow.addActuator("SOLENOIDS", "GearShift1", gearShiftHighLowSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "GearShift2", gearShiftHighLowSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Hammer1", hammerRetractExtendSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Hammer2", hammerRetractExtendSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Foot1", footUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Foot2", footUpDownSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Latch1", shooterLatchSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Latch2", shooterLatchSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade1", tractionWheelUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade2", tractionWheelUpDownSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up1", loadingArmUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up2", loadingArmUpDownSolenoid2);
        
        LiveWindow.addSensor("LIMIT SWITCHES", "BallLimitSwitch", ballLoadedLimitSwitchDIO);
        LiveWindow.addSensor("LIMIT SWITCHES", "ShooterLimitSwitch", shooterLimitSwitchDIO);
        LiveWindow.addSensor("LIMIT SWITCHES", "LimitSwitch", shooterLimitSwitchDIO);
        LiveWindow.addSensor("RangeFinder", "FrontUltrasonic", frontUltrasonicAnalog);

        System.out.println("RobotMap.init end");
    }
}
