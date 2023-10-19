
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
public class PR141Main {


    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/PR1.2-AlexPozas/Project/data/biblioteca.xml";
         

        // Crea una factoria de constructors de documents
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Crea un constructor de documents
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Crea un nou document XML
            Document doc = db.newDocument();
            // Crea l'element root del document XML
            Element elmRoot = doc.createElement("biblioteca");
            // Afegeix l'element root al document XML
            doc.appendChild(elmRoot);
            // Crea l'element "to"
            Element elmTo = doc.createElement("llibre");
            
            Element elmtit = doc.createElement("titol");
            Text nodeText0 = doc.createTextNode("El viatge dels venturons");
            elmtit.appendChild(nodeText0);
            elmTo.appendChild(elmtit);

            Element elmge = doc.createElement("autor");
            Text nodeText1 = doc.createTextNode("Joan Pla");
            elmge.appendChild(nodeText1);
            elmTo.appendChild(elmge);

            Element elmany = doc.createElement("anyPublicacio");
            Text nodeText2 = doc.createTextNode("1998");
            elmany.appendChild(nodeText2);
            elmTo.appendChild(elmany);

            Element elmedi = doc.createElement("editorial");
            Text nodeText3 = doc.createTextNode("Edicions Mar");
            elmedi.appendChild(nodeText3);
            elmTo.appendChild(elmedi);

            Element elmgen = doc.createElement("genere");
            Text nodeText4 = doc.createTextNode("Aventura");
            elmgen.appendChild(nodeText4);
            elmTo.appendChild(elmgen);

            Element elmpag = doc.createElement("pagines");
            Text nodeText5 = doc.createTextNode("320");
            elmpag.appendChild(nodeText5);
            elmTo.appendChild(elmpag);

            Element elmdis = doc.createElement("disponible");
            Text nodeText6 = doc.createTextNode("true");
            elmdis.appendChild(nodeText6);
            elmTo.appendChild(elmdis);
            



            elmRoot.appendChild(elmTo);
            
            // Crea un atribut "id"
            Attr attrId = doc.createAttribute("id");
            // Estableix el valor de l'atribut "id"
            attrId.setValue("001");
            // Afegeix l'atribut "id" a l'element "llibre"
            elmTo.setAttributeNode(attrId);



            write(basePath, doc);

            
          } catch (Exception e) {
             e.printStackTrace();
          }
        
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
