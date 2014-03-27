package team3663.neon;

public class PortMap 
{
    //All ports on the Sidecar PWM
    public static int driveTrainBackLeftSpeedControllerPort   = 1;
    public static int driveTrainBackRightSpeedControllerPort  = 2;
    public static int driveTrainFrontRightSpeedControllerPort = 3;
    public static int driveTrainFrontLeftSpeedControllerPort  = 4;
    public static int ArmSpeedControllerPort                  = 5;
    public static int winchSpeedControllerPort                = 6;

    //All Ports on the Sidecar's Digital IO (1 - 14)
    public static int compressorLimitSwitchDIOPort            = 1;
    public static int winchEncoderPort1                       = 2;
    public static int winchEncoderPort2                       = 3;
    public static int driveTrainLeftEncoder1Port              = 4;
    public static int driveTrainLeftEncoder2Port              = 5;
    public static int driveTrainRightEncoder1Port             = 6;
    public static int driveTrainRightEncoder2Port             = 7;
    public static int shooterLimitSwitchDIOPort               = 8;
    
    //Solenoids
   
    public static int hammerRetractExtendSolenoid1Port        = 1;
    public static int hammerRetractExtendSolenoid2Port        = 2;
    public static int gearShiftHighLowSolenoid1Port           = 3; 
    public static int gearShiftHighLowSolenoid2Port           = 4;
    public static int tractionWheelUpDownSolenoid2Port        = 5;
    public static int tractionWheelUpDownSolenoid1Port        = 6;
    public static int latchSolenoid2Port                      = 7;
    public static int latchSolenoid1Port                      = 8;

    // 2nd puck
    public static int armUpDownSolenoid2Port                  = 1;
    public static int armUpDownSolenoid1Port                  = 2;
    public static int footUpDownSolenoid2Port                 = 3;
    public static int footUpDownSolenoid1Port                 = 4;   
    
    //These are all the Relay ports
    public static int compressorOnOffRelayPort                = 1;
    
    //Module Mappings
    /* A Module is a set of pucks that is stored with the Crio. What
    This means is that you have a Analog, Digital and a Sidecar all ont he module
    So you would have to have another Crio Puck storage for 1 extra module.
    */
    public static int MainModulePort                          = 1;
    public static int SecondaryModulePort                     = 2;
}
