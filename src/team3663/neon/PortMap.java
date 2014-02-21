package team3663.neon;

public class PortMap 
{
    
    //Port Mappings
    
    //All ports on the Sidecar not for Digital IO (1 - 10)
    public static int driveTrainSpeedControllerFrontLeftPort  = 4;//4
    public static int driveTrainSpeedControllerBackLeftPort   = 1;//2
    public static int driveTrainSpeedControllerFrontRightPort = 3;//1
    public static int driveTrainSpeedControllerBackRightPort  = 2;//3
    public static int pickUpSpeedControllerPort               = 5;
    public static int shooterSpeedControllerPort              = 6;

    //All Ports on the Sidecar's Digital IO (1 - 14)
    public static int pneumaticsCompressorLimitSwitchPort     = 1;
    public static int photoelectricGroundSensorPort           = 10;
    public static int shooterLimitSwitchPort                  = 8;
    public static int ballLimitSwitchPort                     = 12;
    public static int shooterEncoderPort1                     = 2;
    public static int shooterEncoderPort2                     = 3;
    public static int driveTrainLeftEncoderport1              = 4;
    public static int driveTrainLeftEncoderport2              = 5;
    public static int driveTrainRightEncoderport1             = 6;
    public static int driveTrainRightEncoderport2             = 7;
    
    //All Digitals IO's not on the sidecar( connected via puck)
    //Solenoids
    public static int driveTrainGearShift1port                = 3; 
    public static int driveTrainGearShift2port                = 4;
    public static int driveTrainDriveChange1port              = 6;
    public static int driveTrainDriveChange2port              = 5;
    
    public static int pickUpSolenoidPort1                     = 2;
    public static int pickUpsolenoidPort2                     = 1;
    //SomethingWrongWithTheseTwo
    public static int hammerSolenoidPort1                     = 1;
    public static int hammerSolenoidPort2                     = 2;
    
    public static int shooterLatchSolenoidPort1               = 8;
    public static int shooterLatchSolenoidPort2               = 7;
    public static int footSolenoidPort1                       = 4;
    public static int footSolenoidPort2                       = 3;
   
    //All analog ports
    public static int rangeFinderFrontUltrasonicPort          = 1;
    
    //These are all the Relay ports
    public static int pneumaticsCompressorSwitchPort          = 1;
    
    //Misc
    //public static int lightsledRelayPort                      = 2; 
    public static int driveTrainGyroPort                      = 1;
    
    //Module Mappings
    /* A Module is a set of pucks that is stored with the Crio. What
    This means is that you have a Analog, Digital and a Sidecar all ont he module
    So you would have to have another Crio Puck storage for 1 extra module.
    This year(2014) we used a 4 puck storage Crio so we use only 1 module
    */
    public static int MainModulePort                          = 1;
    public static int SecondaryModulePort                     = 2;
}
