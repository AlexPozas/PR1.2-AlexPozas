import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123append {
    public static void main(String[] args)throws InterruptedException, IOException {
    BufferedWriter bw = null;
    FileWriter fw = null;

    try {
        String data = "Yo solo puedo mostrarte la puerta\n" ;
         data += "Tu eres quien la tiene que atravesar\n" ;
         String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        File f1 = new File(basePath + "frasesMatrix.txt");
        
    
        fw = new FileWriter(f1.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        System.out.println("información agregada!");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
                        //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
    }
    
}
