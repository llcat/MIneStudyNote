package util;

import java.util.Map;

public class OSExecute {
    public static Process command(String cmd){
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
}
