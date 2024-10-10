import java.util.*;

public class Log {

    private String registroLog;

    public void gerearLog(Object obj, String OP){
        registroLog = obj.toString()+ " - " + OP + " - ";
        System.err.println(registroLog + new Date());
    }
}
