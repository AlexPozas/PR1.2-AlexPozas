import org.w3c.dom.Text;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
public class PR142Main {

    static Scanner in = new Scanner(System.in); 
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/cursos.xml";
        File inputFile = new File(basePath);
         try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                // Crea un objecte XPath
                XPath xPath = XPathFactory.newInstance().newXPath();
                
                boolean running = true;
                while (running) {
                    String menu = "Escull una opció:";
                    menu = menu + "\n 0) Llistar ids de cursos, tutors i total d’alumnes";
                    menu = menu + "\n 1) Mostrar ids i titols dels mòduls a partir d'un id de curs";
                    menu = menu + "\n 2) Llistar alumnes d’un curs";
                    menu = menu + "\n 3) Afegir un alumne a un curs";
                    menu = menu + "\n 4) Eliminar un alumne d'un curs";
                  
              
                    // Adapta aquí les altres classes de l’exercici (PR122cat…)
                    menu = menu + "\n 100) Sortir";
                    System.out.println(menu);
              
              
                    int opcio = Integer.valueOf(llegirLinia("Opció:"));
                    try {
                      switch (opcio) {
                        case 0:
                            //nom del curs, nom del tutor i numero d'alumnes AMS2
                            String curs= llegirLinia("Escriu el curs que vols veure els alumnes: ");
                        
                                String expression = "/cursos/curs[@id='"+curs+"']/alumnes/alumne";
                                String expression1 = "/cursos/curs[@id='"+curs+"']";
                                NodeList listExpression = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
                                NodeList listExpr = (NodeList) xPath.compile(expression1).evaluate(doc, XPathConstants.NODESET);
                                Element elm = (Element) listExpr.item(0);
                
                                System.out.println();
                                System.out.println("CURS: "+curs);
                                System.out.println( "Tutor: "+elm.getElementsByTagName("tutor").item(0).getTextContent());
                                System.out.println("Numero Alumnes: "+listExpression.getLength());
                                System.out.println();
                          break;

                        case 1: 
                        String nom= llegirLinia("Escriu el curs que vols veure els moduls: ");
                        String expression4 = "/cursos/curs[@id='"+nom+"']/moduls/modul";
                        NodeList listExpr4 = (NodeList) xPath.compile(expression4).evaluate(doc, XPathConstants.NODESET);
                
                        for(int temp = 0; temp < listExpr4.getLength(); temp++) {
                            Node nNode = listExpr4.item(temp);
                            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element elm4 = (Element) nNode;
                                System.out.println("Id: "+ elm4.getAttribute("id"));
                                System.out.println("Titol: "+ elm4.getElementsByTagName("titol").item(0).getTextContent());
                        
                            }
                            } break;

                        case 2: 
                        String curs2= llegirLinia("Escriu el curs que vols veure els alumnes: ");
                        String expression5 = "/cursos/curs[@id='"+curs2+"']/alumnes/alumne";
                        NodeList listExpression5 = (NodeList) xPath.compile(expression5).evaluate(doc, XPathConstants.NODESET);
                        System.out.println("Estudiants "+curs2+":  ");
                        System.out.println();
                        for(int temp = 0; temp < listExpression5.getLength(); temp++) {
                            Node nNode = listExpression5.item(temp);
                            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                                Element elm2 = (Element) nNode;
                                System.out.println( elm2.getTextContent());
                        
                            }
                            }
                        System.out.println(); break;

                        case 3: 
                        String curs3= llegirLinia("Escriu el curs: ");
                        String expression6 = "/cursos/curs[@id='"+curs3+"']/alumnes";
                        NodeList list = (NodeList) xPath.compile(expression6).evaluate(doc, XPathConstants.NODESET);
                        Element elmalum = (Element) list.item(0);
                        Element elmTo = doc.createElement("alumne");
                        Text nodeTextTo = doc.createTextNode(llegirLinia("Escriu el nom de un nou alumne: "));
                        elmTo.appendChild(nodeTextTo);
                        elmalum.appendChild(elmTo);
                        write(basePath,doc); break;

                        case 4: 
                        String curs4= llegirLinia("Escriu el curs que vols veure els alumnes: ");
                String expression7 = "/cursos/curs[@id='"+curs4+"']/alumnes";
                NodeList listExpression7 = (NodeList) xPath.compile(expression7).evaluate(doc, XPathConstants.NODESET);

               String nom3= llegirLinia("Escriu el nom del alumne a eliminar: ");
                System.out.println();
                for(int temp = 0; temp < listExpression7.getLength(); temp++) {
                    Node nNode = listExpression7.item(temp);
                    if(nNode.getNodeType() == Node.ELEMENT_NODE){
                        Element elm2 = (Element) nNode;
                        if (elm2.getTextContent().equals(nom3)){
                            Node padre = listExpression7.item(temp).getParentNode();
                            padre.removeChild(elm2.getElementsByTagName("alumne").item(0));
                           
                        }
                        
                        
                     }
                 }
                    write(basePath,doc);

                 System.out.println(); break;
                        
                        case 100: running = false; break;
                        default: break;
                      }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                  }   

          } catch (Exception e) {
             e.printStackTrace();
          }
       



        
    }
    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
  }
  static public void write (String path, Document doc) throws TransformerException, IOException {
    if (!new File(path).exists()) { new File(path).createNewFile(); }
    // Crea una factoria de transformadors XSLT
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    // Crea un transformador XSLT
    Transformer transformer = transformerFactory.newTransformer();
    // Estableix la propietat OMIT_XML_DECLARATION a "no" per no ometre la declaració XML del document XML resultant
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    // Estableix la propietat INDENT a "yes" per indentar el document XML resultant
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    // Elimina els espais en blanc innecessaris del document XML. Implementació pròpia
    
    // Crea una instància de DOMSource a partir del document XML
    DOMSource source = new DOMSource(doc);
    // Crea una instància de StreamResult a partir del camí del fitxer XML
    StreamResult result = new StreamResult(new File(path));
    // Transforma el document XML especificat per source i escriu el document XML
    // resultant a l'objecte especificat per result
    transformer.transform(source, result);
}

}

