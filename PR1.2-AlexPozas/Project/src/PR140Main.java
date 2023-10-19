import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class PR140Main {

   public static void main(String[] args) {

      try {
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/persones.xml";
         File inputFile = new File(basePath);

         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         
         NodeList nList = doc.getElementsByTagName("persona");
         System.out.println();
         System.out.println(String.format("%1$10s %2$11s %3$5s %4$10s","Nom","Cognom","Edat","Ciutat")); 
         System.out.println("----------------------------------------");
         
         for(int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
          
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              String nom= eElement.getElementsByTagName("nom").item(0).getTextContent();
              String cognom= eElement.getElementsByTagName("cognom").item(0).getTextContent();
              String edat= eElement.getElementsByTagName("edat").item(0).getTextContent();
              String ciutat= eElement.getElementsByTagName("ciutat").item(0).getTextContent();

              System.out.println(String.format("%1$10s %2$11s %3$5s %4$10s",nom,cognom,edat,ciutat)); 
            
            
                        }
          }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}









