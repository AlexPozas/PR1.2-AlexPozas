import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class PR133mainTreballadors {
     static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
       String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/";
        String fileName = "PR133treballadors.csv";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        } 
    List<String> csv = UtilsCSV.read(filePath);
    String[] columnes = UtilsCSV.getKeys(csv);
    
    System.out.println("Les columnes són: " + Arrays.toString(columnes));
    System.out.println("Escriu el Id de la persona que vols modificar:");
    String id =  in.nextLine();

    int numLinia = UtilsCSV.getLineNumber(csv, "Id", id);
    
    boolean running = true;
    while (running) {
      String menu = "Escull la opció que vols modificar:";
      menu = menu + "\n 0) Nom";
      menu = menu + "\n 1) Cognom";
      menu = menu + "\n 2) Departament";
      menu = menu + "\n 3) Salari";
      
      // Adapta aquí les altres classes de l’exercici (PR122cat…)
      menu = menu + "\n 100) Sortir";
      System.out.println(menu);

      String strLiniaAvatar = csv.get(numLinia);
      int opcio = Integer.valueOf(llegirLinia("Opció:"));
      String[] arrAvatar = UtilsCSV.getLineArray(strLiniaAvatar);
      try {
        switch (opcio) {
            
          case 0:
          int posnom = UtilsCSV.csvGetColumnPosition(csv, "Nom");
          int oldnom = Integer.parseInt(arrAvatar[posnom]);
          System.out.println("Escriu el nou nom");
          String nom =  in.nextLine();
          UtilsCSV.update(csv, numLinia, "Nom",nom);
          UtilsCSV.write(filePath, csv);
          System.out.println("S'ha canviat el nom avans, era " + oldnom + " i s'ha posat " + nom);

          break;

          case 1:
          int poscognom = UtilsCSV.csvGetColumnPosition(csv, "Cognom");
          int oldcognom = Integer.parseInt(arrAvatar[poscognom]);
          System.out.println("Escriu el nou cognom");
          String cognom =  in.nextLine();
          UtilsCSV.update(csv, numLinia, "Cognom",cognom); 
          UtilsCSV.write(filePath, csv);
          System.out.println("S'ha canviat el cognom avans, era " + oldcognom + " i s'ha posat " + cognom);
          break;

          case 2:
          int posdep = UtilsCSV.csvGetColumnPosition(csv, "Departament");
          int olddep = Integer.parseInt(arrAvatar[posdep]);
          System.out.println("Escriu el nou departament");
          String departament =  in.nextLine();
          if(isNumeric(departament) == true){
          UtilsCSV.update(csv, numLinia, "Departament",departament); 
          UtilsCSV.write(filePath, csv);
          System.out.println("S'ha canviat el departament avans, era " + olddep + " i s'ha posat " + departament);

        } else {
            System.out.println("No es un numero");

        }
          break;

          case 3:
          int possal = UtilsCSV.csvGetColumnPosition(csv, "Salari");
          int oldsal = Integer.parseInt(arrAvatar[possal]);
          System.out.println("Escriu el nou salari");
          String salari =  in.nextLine();
          if(isNumeric(salari) == true){
            UtilsCSV.update(csv, numLinia, "Salari",salari); 
            UtilsCSV.write(filePath, csv);
            System.out.println("S'ha canviat el salari avans, era " + oldsal + " i s'ha posat " + salari);

          }else {
            System.out.println("No es un numero");
        }
          
          break;

          case 100: running = false; break;
          default: break;
        }
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    in.close();
    }
  static public String llegirLinia (String text) {
    System.out.print(text);
    return in.nextLine();
  }
  public static boolean isNumeric(String cadena) {

    boolean resultado;

    try {
        Integer.parseInt(cadena);
        resultado = true;
    } catch (NumberFormatException excepcion) {
        resultado = false;
    }

    return resultado;
}
}
