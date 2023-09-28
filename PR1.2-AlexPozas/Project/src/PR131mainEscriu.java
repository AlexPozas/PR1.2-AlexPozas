import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class PR131mainEscriu {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        String filePath = basePath + "PR131HashMapData.ser";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        System.out.println("");

        try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
            HashMap<String, String> capitalCities = new HashMap<String,String>();
            capitalCities.put("England", "London");
            capitalCities.put("Germany", "Berlin");


            PR131hashmap has = new PR131hashmap(capitalCities);
            
            

			oos.writeObject(has);
           

			oos.close();
			fos.close();

            System.out.println("Llest");

		} catch (IOException e) { e.printStackTrace(); }
    }
    
}
