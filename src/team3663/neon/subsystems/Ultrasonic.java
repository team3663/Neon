package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3663.neon.RobotMap;
import team3663.neon.commands.RangeFinder;

public class Ultrasonic extends Subsystem
{
    public AnalogChannel backUS, rightUS;
    double[] distances;
    
    public void Init()
    {
        backUS = RobotMap.rangeFinderBackUltrasonic;
        rightUS = RobotMap.rangeFinderRightUltrasonic;
        distances = new double[3];
    }
    
    public void initDefaultCommand()
    {
        setDefaultCommand(new RangeFinder());
    }
    
    public double[] getDistanceInches()
    {
        distances[0] = Math.floor(backUS.getVoltage() / 0.0098);
        distances[1] = Math.floor(rightUS.getVoltage() / 0.0098);
        //System.out.println("Distance right: " + distances[1] + "Distance Back: " + distances[0]);
        return distances;
    }
}
