package socketrpc.server;

import java.io.File;
import java.io.FileInputStream;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class XPathDemo {
    private static Document doc;
    private static XPath xpath;
//初始化Document,XPath对象
    public static void init() throws Exception {
        // 创建Document对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new FileInputStream(new File("FindFlight.xml")));
 
        //创建XPath对象
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
    }

    //查询机票
    public static String getAttrEles(String string) throws XPathExpressionException {
        NodeList nodeList = (NodeList) xpath.evaluate("//flightinfo/flight[leaveairport='"+string+"']", doc,
                XPathConstants.NODESET);
        String st = new String();
        st="             ";
        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.print(nodeList.item(i).getNodeName() + "-->"
//                    + nodeList.item(i).getTextContent() + " ");
        	st += nodeList.item(i).getNodeName()+(i+1)+":"+nodeList.item(i).getTextContent();
        }
       return st;
    }
}