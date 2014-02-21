package team3663.neon.commands;

import edu.wpi.first.wpilibj.Timer;

public class TurnDegreesCommand extends CommandBase
{
    private double _degreesToTurn;
    private double _turnSpeed;
    
    public TurnDegreesCommand(double degreesToTurn, double turnSpeed)
    {
        requires(driveTrain);
        _degreesToTurn = degreesToTurn;
        _turnSpeed = turnSpeed;
        if(_degreesToTurn > 0)
        {
            _turnSpeed *= -1;
        }
    }
    
    protected void initialize()
    {
    }
    protected void execute()
    {
        driveTrain.Drive(0.0, _turnSpeed);
    }
    protected boolean isFinished()
    {
        //todo: make this work with encoders
        double turnProgress = 0;
        if ((_turnSpeed > 0) && (turnProgress > _degreesToTurn)) 
		return false;
        else if ((_turnSpeed < 0) && (turnProgress < _degreesToTurn))
		return false;
	else
		return true;
    }
    protected void end()
    {
        driveTrain.Stop();
    }
    protected void interrupted()
    {
        end();
    }
}
