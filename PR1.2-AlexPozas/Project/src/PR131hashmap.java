import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap  implements Serializable{
       HashMap<String, String> has;
       PR131hashmap (HashMap has) {
        this.has= has;
       
    }

    @Override
    public String toString () {
        return "HasMap: " + this.has ;
    }
    
}
