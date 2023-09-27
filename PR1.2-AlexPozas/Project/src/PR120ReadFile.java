import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;


public class PR120ReadFile {
  public static void main(String args[]) {
        int lineNumber = 1;
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        String fileName = "Arxiu.txt";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

        File file = new File(filePath);

        Scanner scnr;
        try {
            scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                lineNumber++;
                String line = scnr.nextLine();
                System.out.println("numero de linia: "+lineNumber+" linia "+line);
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
 
}
