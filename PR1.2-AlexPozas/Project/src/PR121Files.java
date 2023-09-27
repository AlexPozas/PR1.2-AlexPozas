import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;


public class PR121Files {


  // Mainhj
  public static void main(String[] args) throws InterruptedException, IOException {
    String basePath = System.getProperty("user.dir") + "/Project/myFiles/";
        String fileName = "Arxiu.txt";
        String filePath = basePath + fileName;

        // Crear la carpeta 'myFiles' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'myFiles'");
            }
        }

        System.out.println("");
            // Crear un arxiu
            File f1 = new File(basePath + "file1.txt");
            boolean arxiuCreat = f1.createNewFile();
            if (arxiuCreat) {
                System.out.println("S'ha creat l'arxiu \"" + f1.getName() + "\"");
            } else {
                System.out.println("No s'ha pogut crear l'arxiu \"" + f1.getName() + "\"");
            }

            TimeUnit.SECONDS.sleep(1);
          // Crear un arxiu
            File f2 = new File(basePath + "file2.txt");
            boolean arxiuCreat2 = f2.createNewFile();
            if (arxiuCreat) {
                System.out.println("S'ha creat l'arxiu \"" + f2.getName() + "\"");
            } else {
                System.out.println("No s'ha pogut crear l'arxiu \"" + f2.getName() + "\"");
            }

            TimeUnit.SECONDS.sleep(1);


  }
 
}
