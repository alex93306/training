package thinkInJava.xml;

import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by ALEX on 28.07.2016.
 */
public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        File f = new File("F:\\Projects\\training\\javaSE\\src\\main\\resources\\books.xml");
        /*DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=factory.newDocumentBuilder();
        Document document=documentBuilder.parse(f);
        Element root=document.getDocumentElement();
        System.out.println("root: " + root.getNodeName());
        NodeList childNodes=root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node=childNodes.item(i);
            if(node instanceof Element) {
                NodeList element=node.getChildNodes();
                for (int j = 0; j < element.getLength(); j++) {
                    System.out.println(element.item(j).getTextContent());
                }
            }
        }*/
       /* DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(f);
        XPathFactory xPathFactory=XPathFactory.newInstance();
        XPath xpath=xPathFactory.newXPath();
        Node node= (Node) xpath.evaluate("/bookstore/book[1]/title/@lang", document, XPathConstants.NODE);
        System.out.println(node.getTextContent());*/

        DefaultHandler defaultHandler=new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if(localName.equals("book") && attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        String name=attributes.getLocalName(i);
                        if(name.equals("category")) {
                            System.out.println(attributes.getValue(i));
                        }
                    }
                }
            }
        };
        SAXParserFactory factory=SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser parser=factory.newSAXParser();
        parser.parse(f, defaultHandler);


    }
}
