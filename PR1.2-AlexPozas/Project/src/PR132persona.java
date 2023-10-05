import java.io.Serializable;

public class PR132persona implements Serializable{

    private String nom;
   private String cognom;
   private int edat;

   
public PR132persona(String nom, String cognom, int edat) {
    this.nom = nom;
    this.cognom = cognom;
    this.edat = edat;
}

public String getNom() {
    return nom;
}
public void setNom(String nom) {
    this.nom = nom;
}
public String getCognom() {
    return cognom;
}
public void setCognom(String cognom) {
    this.cognom = cognom;
}
public int getEdat() {
    return edat;
}
public void setEdat(int edat) {
    this.edat = edat;
}

@Override
public String toString() {
    return "Persona: Nom=" + nom + ", Cognom=" + cognom + ", Edat=" + edat ;
}
   


    
}
