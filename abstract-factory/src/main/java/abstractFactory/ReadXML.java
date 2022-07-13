package abstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Objects;

public class ReadXML {

    public static Object getObject() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            String url = Objects.requireNonNull(ReadXML.class.getClassLoader().getResource("config.xml")).getPath();
            doc = builder.parse(url);
            NodeList nodeList = doc.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String nodeValue = node.getNodeValue();
            String cName = "abstractFactory." + nodeValue;
            Class<?> clazz = Class.forName(cName);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
