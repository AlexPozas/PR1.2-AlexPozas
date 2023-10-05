import java.io.RandomAccessFile;

public class PR134treballadors {

    private static final int ID_SIZE = 4; 
    private static final int NAME_SIZE = 20; 
    private static final int Nota_size = 4; 

    public static void main(String[] args) {


     try (
        RandomAccessFile raf = new RandomAccessFile(System.getProperty("user.dir")  +"/PR1.2-AlexPozas/Project/data/Universitat.dat", "rw")) {
            // Afegir videojocs
            afegirStudiant(raf, 1, "Assassin's Creed",5);
            afegirStudiant(raf, 2, "The Legend of Zelda",5);


            


        
           


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void afegirStudiant(RandomAccessFile raf, int id, String nom,int nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);
        raf.writeChars(getPaddedName(nom));
        raf.writeInt(nota);
    }

    private static String getPaddedName(String name) {
        // Si el nom és més llarg que la mida màxima permesa (NAME_SIZE),
        // es trunca per ajustar-se a aquesta mida.
        if (name.length() > NAME_SIZE) {
            return name.substring(0, NAME_SIZE);
        }
        // Si el nom és més curt que NAME_SIZE, s'omple amb espais en blanc fins a assolir aquesta mida.
        // String.format amb "%1$-" + NAME_SIZE + "s" assegura que la cadena resultant tingui una longitud fixa.
        return String.format("%1$-" + NAME_SIZE + "s", name);
    }
    public static void mostrarVideojoc(RandomAccessFile raf, int id, String msg) throws Exception {
        System.out.println(msg + " " + id + ": " + consultar(raf, id));
    }



}
