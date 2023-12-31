import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;


public class PR121Files {

  public static void main(String[] args) throws InterruptedException, IOException {
    String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/myFiles/";

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
            File f2new = new File(basePath + "renamedFile.txt");
            f2.renameTo(f2new);
            System.out.println("file2 canviat de nombre a renamedFile");
            System.out.println(" ");

            String[] listado = dir.list();
            if (listado == null || listado.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
                return;
                    }
            else {
                System.out.println("Els arxius de la carpeta són: ");
                for (int i=0; i< listado.length; i++) {
                    System.out.println(listado[i]);
                    }
                }
                f1.delete();
            
                String[] listadonuevo = dir.list();
            if (listado == null || listado.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
                return;
                    }
            else {
                System.out.println("Els arxius de la carpeta són: ");
                for (int i=0; i< listadonuevo.length; i++) {
                    System.out.println(listadonuevo[i]);
                    }
                }

  }
 
}
