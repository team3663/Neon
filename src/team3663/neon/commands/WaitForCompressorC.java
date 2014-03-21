package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WaitForCompressorC extends CommandBase {
    
    public WaitForCompressorC() {
    }

    protected void initialize() {
        SmartDashboard.putString("WaitForCompressorC", "initialize");        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(compressorSS.airTanksAreFull())
        {
            return true;
        }
        return false;
    }

    protected void end() {
        SmartDashboard.putString("WaitForCompressorC", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("WaitForCompressorC", "interrupted");        
    }
}
