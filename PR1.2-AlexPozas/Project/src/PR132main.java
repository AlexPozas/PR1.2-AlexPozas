import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PR132main {

    public static void main(String[] args) {

        PR132persona p1 = new PR132persona("Maria", "López", 36);
        PR132persona p2 = new PR132persona("Gustavo", "Ponts", 63);
        PR132persona p3 = new PR132persona("Irene", "Sales", 54);
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        String filePath = basePath + "PR132people.dat";
        try {
            
           FileOutputStream fos = new FileOutputStream(filePath);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(p1);
           oos.writeObject(p2);
           oos.writeObject(p3);
           System.out.println("Done");
           oos.close();
           fos.close();
       } catch (IOException e) { e.printStackTrace(); }


       
       try {
           FileInputStream is = new FileInputStream(filePath);
           ObjectInputStream ois = new ObjectInputStream(is);
           PR132persona per0 = (PR132persona) ois.readObject();
           PR132persona per1 = (PR132persona) ois.readObject();
           PR132persona per2 = (PR132persona) ois.readObject();
          
            System.out.println(per0.toString());
            System.out.println(per1.toString());
            System.out.println(per2.toString());
           ois.close();
           is.close();
           
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) { e.printStackTrace(); }
        
    }
    
}
