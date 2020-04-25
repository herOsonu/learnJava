package XmlReader;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DomDemo {
    public static DocumentBuilder getDocumentBuilder(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db =null;
        try {
            db=dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }
    public static void parseDemo() {
        try {
            //3.通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
            Document document =getDocumentBuilder().parse("books.xml");
            //获取所用book节点的的集合
            NodeList bookList = document.getElementsByTagName("book");
            //遍历每一个book节点
            //通过NodeList的getLength方法获取bookList的长度
            System.out.println(bookList.getLength());
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("======下面开始遍历第" + (i + 1) + "本书的内容======");
                //通过item（i）方法，获取一个book节点，nodelist的索引值从0开始
                Node book = bookList.item(i);
                //获取book节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                //遍历book的属性
                System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
                for (int j = 0; j < attrs.getLength(); j++) {
                    //通过item方法获取属性
                    Node attr = attrs.item(j);
                    System.out.print("属性名：" + attr.getNodeName());
                    System.out.println("--" + attr.getNodeValue());
                    NodeList childNode = book.getChildNodes();

                    for (int m = 0; m < childNode.getLength(); m++) {
                        if (!(childNode.item(m).getNodeType() == Node.ELEMENT_NODE)) {
                            continue;
                        }
                        System.out.print(childNode.item(m).getNodeName());
                        System.out.println("--" + childNode.item(m).getFirstChild().getNodeValue());
                    }

                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createXML(){
        DocumentBuilder db=getDocumentBuilder();
        Document document=db.newDocument();
        document.setXmlStandalone(true);//表头standalone为yes且不显示
        Element bookstore=document.createElement("bookstore");
        Element book=document.createElement("book");
        Element name=document.createElement("name");
        name.setTextContent("吉姆雷诺");
        book.appendChild(name);
        book.setAttribute("id","1");
        bookstore.appendChild(book);
        document.appendChild(bookstore);
        TransformerFactory tff=TransformerFactory.newDefaultInstance();

        try {
            Transformer tf=tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT,"yes");
            tf.transform(new DOMSource(document),new StreamResult(new File("books1.xml")));
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }
}

