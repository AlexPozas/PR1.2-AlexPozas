import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class PR134treballadors {

    private static final int ID_SIZE = 4; 
    private static final int NAME_SIZE = 20; 
    private static final float Nota_size = 4; 
    private static final int CHAR_SIZE = 2;
static Scanner in = new Scanner(System.in); // System.in és global
    public static void main(String[] args) {
        ArrayList<Integer> ids = new ArrayList<>();
        
        
     try (
        RandomAccessFile raf = new RandomAccessFile(System.getProperty("user.dir")  +"/Project/data/Universitat.dat", "rw")) {
            // Afegir videojocs
            boolean running = true;
            while (running) {
              String menu = "Escull una opció:";
              menu = menu + "\n 0) Afegir un estudiant";
              menu = menu + "\n 1) Actualitzar la nota del estudiant";
              menu = menu + "\n 2) Mostrar la nota del estudiant";
             
              // Adapta aquí les altres classes de l’exercici (PR122cat…)
              menu = menu + "\n 100) Sortir";
              System.out.println(menu);
        
        
              int opcio = Integer.valueOf(llegirLinia("Opció:"));
              try {
                switch (opcio) {
                  case 0: 
                  System.out.println("Escriu el nou Estudiant: ");
                  String nom =  in.nextLine();
                  
                  String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
                  boolean specialchar = false;
                  boolean numero = false;
                  if (nom.length() > 1 ){
                    for (int i = 0; i < nom.length(); i++) {
                        if (specialChars.contains(String.valueOf(nom.charAt(i)))) {
                            specialchar = true;
                        } else if (Character.isDigit(Integer.valueOf(nom.charAt(i)))) {
                            numero = true;
                        }
                            }
                    if (specialchar==false && numero==false) {
                        System.out.println("El " + nom + " es valido");
                        System.out.println("Escriu la nota: ");
                        String nota =  in.nextLine();
                        
                        if (isNumeric(nota) ){
                            if (ids.isEmpty()){
                               afegirStudiant(raf,1 , nom,nota); 
                               ids.add(1);
                            }
                            else{
                                afegirStudiant(raf,ids.get(ids.size()-1)+1, nom,nota); 
                                ids.add(ids.get(ids.size()-1)+1);

                            }
                            
                        }else {
                        System.out.println("Nota no es valida");}

                    } else {
                        System.out.println("No es valido");}}
                   break;
                  case 1: System.out.println("Escriu el id");
                        String id =  in.nextLine();
                        boolean existe = ids.contains(id);
                        if (isNumeric(id)&& existe){
                            System.out.println("Escriu la nova nota: ");
                            String nota =  in.nextLine();
                            if (isNumeric(nota)){
                                actualitzarNota(raf, Integer.parseInt(id), nota);
                            }
                            
                        }else {
                        System.out.println("id no es valida");}
                             break;
                  case 2:  
                        System.out.println("Escriu el id: ");
                         id =  in.nextLine();
                         existe = ids.contains(id);
                        if (isNumeric(id)&& existe){
                            mostrarEstudiant(raf, Integer.parseInt(id), "Nota");

                        }else {
                        System.out.println("id no es valida");} break;
                 
                  case 100: running = false; break;
                  default: break;
                }
              } catch (Exception e) {
                  System.out.println(e);
              }
            }
            in.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
      }


    public static void afegirStudiant(RandomAccessFile raf, int id, String nom,String nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);
        raf.writeChars(getPaddedName(nom));
        raf.writeChars(getPaddedNota(nota));
    }


    

    public static void mostrarEstudiant(RandomAccessFile raf, int id, String msg) throws Exception {
        
        String nota= consultarEstudiant(raf, id);
        String n=String.valueOf(nota.charAt(nota.length()-2))+nota.charAt(nota.length()-1);
        System.out.println();
        System.out.println(msg + " " + id + ": " + n);
        System.out.println();
        
    }
    
    public static String consultarEstudiant(RandomAccessFile raf, int id) throws Exception {
        raf.seek(getSeekPosition(id));
        raf.readInt(); 
        
        char[] chars = new char[NAME_SIZE+(int)+Nota_size];
        for (int i = 0; i < NAME_SIZE+(int)+Nota_size; i++) {
            chars[i] = raf.readChar(); 
        }
        return new String(chars).trim();
    }

    public static void actualitzarNota(RandomAccessFile raf, int id, String nouNota) throws Exception {
        raf.seek(getSeekPosition(id) + ID_SIZE+NAME_SIZE*CHAR_SIZE);
        raf.writeChars(getPaddedNota(nouNota));
    }

    private static long getSeekPosition(int id) {
        
        return (id - 1) * (ID_SIZE + NAME_SIZE* CHAR_SIZE + (int)Nota_size*CHAR_SIZE);
    }

    private static String getPaddedName(String name) {
        
        if (name.length() > NAME_SIZE) {
            return name.substring(0, NAME_SIZE);
        }
        return String.format("%1$-" + NAME_SIZE + "s", name);
    }

    
    private static String getPaddedNota(String nota) {
        
        if (nota.length() > (int) Nota_size) {
            return nota.substring(0, (int) Nota_size);
        }
        return String.format("%1$-" + (int) Nota_size + "s", nota);
    }
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
