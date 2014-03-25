
package team3663.neon.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class C_RecordToSmartDashboard extends CommandBase {
    String key;
    String value;
    
    public C_RecordToSmartDashboard(String pKey, String pValue) {
        key = pKey;
        value = pValue;
    }
    
    protected void initialize() {
        SmartDashboard.putString(key, value);
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
    }

    protected void interrupted() {
    }
}
