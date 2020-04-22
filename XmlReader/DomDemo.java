package XmlReader;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomDemo {
    public static void parseDemo() {
        //1.创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //2.创建一个DocumentBuilder对象
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            //3.通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
            Document document = db.parse("books.xml");
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
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();


        }
    }
}

