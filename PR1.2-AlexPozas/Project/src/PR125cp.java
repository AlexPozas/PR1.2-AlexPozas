import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class PR125cp {
    private static void copyFile(File src, File dest) throws IOException {
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    static Scanner in = new Scanner(System.in); // System.in és global

    public static void main(String[] args) throws InterruptedException, IOException{
        String arxiu = String.valueOf(llegirLinia("nom Arxiu:"));
        String ruta = String.valueOf(llegirLinia("Ruta origen:"));
        File fRuta = new File(ruta+"/"+arxiu);

        String rutafinal = String.valueOf(llegirLinia("Ruta final:"));
        File fRutafinal = new File(rutafinal+"/"+arxiu);
        if (fRuta.exists()) {
           copyFile(fRuta, fRutafinal);
           System.out.println("");
            System.out.println("Arxiu copiat .");
            System.out.println("");
        }
            
        else{
            System.out.println("OJO: ¡¡No existe la ruta!!");
            System.out.println("");
        }
        
    }
    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
  }
}
