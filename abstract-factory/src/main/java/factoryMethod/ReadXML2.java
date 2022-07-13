package factoryMethod;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ReadXML2 {
    public static Object getObject() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc;
            String url = ReadXML2.class.getClassLoader().getResource("config2.xml").getPath();
            doc = documentBuilder.parse(new File(url));

            NodeList className = doc.getElementsByTagName("className");
            Node node = className.item(0).getFirstChild();
            String value = node.getNodeValue();
            String cName = "factoryMethod." + value;
            Class<?> aClass = Class.forName(cName);
            Object instance = aClass.getDeclaredConstructor().newInstance();
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
