
package team3663.neon.commands;

import team3663.neon.Robot3663;

public class C_RecordToSmartDashboard extends CommandBase {
    String key;
    String value;
    
    public C_RecordToSmartDashboard(String pKey, String pValue) {
        key = pKey;
        value = pValue;
    }
    
    protected void initialize() {
        Robot3663.updateCGStatus(key,value);
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
