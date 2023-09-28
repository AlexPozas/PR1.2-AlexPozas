import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PR122cat {
    static Scanner in = new Scanner(System.in); // System.in és global
    public static void main(String[] args)throws InterruptedException, IOException {
        String ruta = String.valueOf(llegirLinia("Ruta:"));
        File fRuta = new File(ruta);
        if (fRuta.exists()) {
            if (fRuta.isDirectory()){System.out.println("Es un directorio");
            System.out.println("");}
            else {
                File file = new File(ruta);
                Scanner scnr;
                try {
                    scnr = new Scanner(fRuta);
                    while(scnr.hasNextLine()){
                    String line = scnr.nextLine();
                    System.out.println(" linia "+line);
                    System.out.println("");
                    } 
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                                    }}}
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
