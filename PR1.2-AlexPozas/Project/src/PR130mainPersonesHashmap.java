import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class PR130mainPersonesHashmap {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, Integer> persones = new HashMap<String,Integer>();
     
        // Add keys and values (Country, City)
        persones.put("Pedro", 30);
        persones.put("Alex", 20);
        persones.put("Lidia", 40);
        persones.put("Jordi", 50);
        persones.put("Nut", 20);
        
        System.out.println(persones);
        
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        String filePath = basePath + "PR130persones.dat";
        
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;

        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;

        try {
            fileOutputStream=new FileOutputStream(filePath);
            dataOutputStream=new DataOutputStream(fileOutputStream);
            for (String key: persones.keySet()) {
                dataOutputStream.writeUTF(key);
                dataOutputStream.writeInt(persones.get(key));
                
            }

            fileInputStream = new FileInputStream(filePath);
            dataInputStream = new DataInputStream(fileInputStream);
            for (int i = 0; i < 5; i++) {
                System.out.println("Nom: "+dataInputStream.readUTF()+", "+"Edat: "+dataInputStream.readInt());
                
                
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }    finally {
            try {
                if(fileOutputStream!=null){ fileOutputStream.close(); }
                if(dataOutputStream!=null){ dataOutputStream.close(); }
                if(fileInputStream!=null){ fileInputStream.close(); }
                if(dataInputStream!=null){ dataInputStream.close(); }
            } catch (Exception e) {
                e.printStackTrace();
    }
}



        
      }
     
    
}
