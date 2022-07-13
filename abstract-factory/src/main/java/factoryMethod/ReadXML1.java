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
import java.util.Objects;

public class ReadXML1 {

    public static Object getObject() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc;
            String url = Objects.requireNonNull(ReadXML1.class.getClassLoader().getResource("config1.xml")).getPath();
            doc = documentBuilder.parse(new File(url));

            NodeList nodeList = doc.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String cName = node.getNodeValue();
            cName = "factoryMethod." + cName;

            Class<?> clazz = Class.forName(cName);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            return instance;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
