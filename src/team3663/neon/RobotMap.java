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
    public static SpeedController armSpeedController;
    public static SpeedController winchSpeedController;
    
    public static Encoder winchEncoder;
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    
    public static Solenoid gearShiftHighLowSolenoid1;
    public static Solenoid gearShiftHighLowSolenoid2;
    public static Solenoid tractionWheelUpDownSolenoid1;
    public static Solenoid tractionWheelUpDownSolenoid2;
    public static Solenoid armUpDownSolenoid1;
    public static Solenoid armUpDownSolenoid2;
    public static Solenoid latchSolenoid1;
    public static Solenoid latchSolenoid2;
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
        
        gearShiftHighLowSolenoid1 = new Solenoid(PortMap.MainModulePort,PortMap.gearShiftHighLowSolenoid1Port);
        gearShiftHighLowSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.gearShiftHighLowSolenoid2Port);

        tractionWheelUpDownSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.tractionWheelUpDownSolenoid1Port);
        tractionWheelUpDownSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.tractionWheelUpDownSolenoid2Port);

        //End of driveTrain sensors and items------------------------------------------------------------------

        //Components relating to current game(2014) Shooter items Start----------------------------------------

        armUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.armUpDownSolenoid1Port);
        armUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.armUpDownSolenoid2Port);

        hammerRetractExtendSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.hammerRetractExtendSolenoid1Port);
        hammerRetractExtendSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.hammerRetractExtendSolenoid2Port);

        footUpDownSolenoid1 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid1Port);
        footUpDownSolenoid2 = new Solenoid(PortMap.SecondaryModulePort, PortMap.footUpDownSolenoid2Port);

        latchSolenoid1 = new Solenoid(PortMap.MainModulePort, PortMap.latchSolenoid1Port);
        latchSolenoid2 = new Solenoid(PortMap.MainModulePort, PortMap.latchSolenoid2Port);

        winchSpeedController = new Victor(PortMap.MainModulePort, PortMap.winchSpeedControllerPort);
        
        winchEncoder = new Encoder(PortMap.MainModulePort, PortMap.winchEncoderPort1, 
                                     PortMap.MainModulePort, PortMap.winchEncoderPort2);
        
        winchEncoder.setDistancePerPulse(1.0);
        winchEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        winchEncoder.start();
        
        armSpeedController = new Victor(PortMap.MainModulePort, PortMap.ArmSpeedControllerPort); 
        shooterLimitSwitchDIO = new DigitalInput(PortMap.MainModulePort, PortMap.shooterLimitSwitchDIOPort);
        
        compressorOnOffRelay = new Relay(PortMap.MainModulePort, PortMap.compressorOnOffRelayPort);
        compressorLimitSwitchDIO = new DigitalInput(PortMap.MainModulePort, PortMap.compressorLimitSwitchDIOPort);
        
        //All LiveWindow actuators add here
        /*
        LiveWindow.addActuator("VICTORS", "SpeedControllerFrontLeft", (Victor)driveTrainFrontLeftSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeedControllerBackLeft", (Victor)driveTrainBackLeftSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerFrontRight",(Victor)driveTrainFrontRightSpeedController);
        LiveWindow.addActuator("VICTORS", "SpeeedControllerBackRight",(Victor)driveTrainBackRightSpeedController);
        LiveWindow.addActuator("VICTORS", "Pick up wheels", (Victor)armSpeedController);
        LiveWindow.addActuator("VICTORS", "Winch Motor", (Victor)winchSpeedController);
        
        LiveWindow.addSensor("ENCODERS", "LeftEncoder", driveTrainLeftEncoder);
        LiveWindow.addSensor("ENCODERS", "RightEncoder", driveTrainRightEncoder);
        LiveWindow.addSensor("ENCODERS", "Winch Encoder", winchEncoder);
        
        LiveWindow.addActuator("PNEUMATICS", "CompressorOnOffRelay", compressorOnOffRelay);
        LiveWindow.addSensor("PNEUMATICS", "CompressorLimitSwitch", compressorLimitSwitchDIO);
        
        LiveWindow.addActuator("SOLENOIDS", "GearShift1", gearShiftHighLowSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "GearShift2", gearShiftHighLowSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Hammer1", hammerRetractExtendSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Hammer2", hammerRetractExtendSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Foot1", footUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Foot2", footUpDownSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Latch1", latchSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Latch2", latchSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade1", tractionWheelUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Mecanum/Arcade2", tractionWheelUpDownSolenoid2);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up1", armUpDownSolenoid1);
        LiveWindow.addActuator("SOLENOIDS", "Pick Up2", armUpDownSolenoid2);
        
        LiveWindow.addSensor("LIMIT SWITCHES", "ShooterLimitSwitch", shooterLimitSwitchDIO);
*/
        System.out.println("RobotMap.init end");
    }
}
