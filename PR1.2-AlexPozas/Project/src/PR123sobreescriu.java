import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123sobreescriu {
    
public static void main(String[] args) throws InterruptedException, IOException{

    String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
    File f1 = new File(basePath + "frasesMatrix.txt");
    boolean arxiuCreat = f1.createNewFile();
    if (arxiuCreat) {
        System.out.println("S'ha creat l'arxiu \"" + f1.getName() + "\"");
    } else {
        System.out.println("No s'ha pogut crear l'arxiu \"" + f1.getName() + "\"");
    }

   try {
       FileWriter myWriter = new FileWriter(f1);
       
       myWriter.write("Yo solo puedo mostrarte la puerta\n"); 
        myWriter.write("Tu eres quien la tiene que atravesar\n"); 
    
    

       myWriter.close();
       System.out.println("Successfully wrote to the file.");
     } catch (IOException e) { e.printStackTrace(); }
 }
}
