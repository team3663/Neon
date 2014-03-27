package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class C_WaitForCompressor extends CommandBase {
    
    public C_WaitForCompressor() {
    }

    protected void initialize() {
        SmartDashboard.putString("C_WaitForCompressor", "initialize");        
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
        SmartDashboard.putString("C_WaitForCompressor", "end");        
    }

    protected void interrupted() {
        SmartDashboard.putString("C_WaitForCompressor", "interrupted");        
    }
}
