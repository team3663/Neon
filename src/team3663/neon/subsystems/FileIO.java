package team3663.neon.subsystems;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataOutputStream;
import java.io.PrintStream;
import javax.microedition.io.Connector;

/*
 * @author Kainoa & Tyler
 */

public class FileIO 
{
    PrintStream out;
    DataOutputStream theFile;
    FileConnection fc;
    
    public FileIO()
    {
        
    }
    
    public void Write(String s)
    {
        try 
        {
            fc = (FileConnection)Connector.open("file:///output.txt", Connector.WRITE);
            fc.create();
            theFile = fc.openDataOutputStream();
            out = new PrintStream(theFile);
        } catch (java.io.IOException e) {
            System.err.println(e);
        }
    }
    
    public void Read(String file)
    {
        
    }
    
    public void Append(String s)
    {
        out.println(s);   
    }
}
