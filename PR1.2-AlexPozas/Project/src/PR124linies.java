import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class PR124linies {
    public static void main(String[] args) throws InterruptedException, IOException{

        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        File f1 = new File(basePath + "numeros.txt");
        boolean arxiuCreat = f1.createNewFile();
        if (arxiuCreat) {
            System.out.println("S'ha creat l'arxiu \"" + f1.getName() + "\"");
        } else {
            System.out.println("No s'ha pogut crear l'arxiu \"" + f1.getName() + "\"");
        }
    
       try {
           FileWriter myWriter = new FileWriter(f1);
           for (int i = 1; i <= 10; i++) {
           myWriter.write(String.valueOf(Math.floor(Math.random()*(10-1+1)+1))); 
            myWriter.write("\n");
        }
    
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
         } catch (IOException e) { e.printStackTrace(); }
     }

    
}
