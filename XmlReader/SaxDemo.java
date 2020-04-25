package XmlReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaxDemo {
    public static ArrayList<Book> parseDemo(){
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SaxParseHandler handler=null;
        try {
            SAXParser parser=factory.newSAXParser();
            handler=new SaxParseHandler();
            parser.parse("books.xml",handler);
            System.out.println("共有"+handler.getBookList().size()+"本书");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler.getBookList();


    }
    public void createXML(){
        ArrayList<Book> books=parseDemo();
        SAXTransformerFactory tff=(SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler transformerHandler=tff.newTransformerHandler();
            Transformer transformer=transformerHandler.getTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");//设置换行
            File file=new File("newBooks.xml");
            if(!file.exists()){
                file.createNewFile();
            }
            Result result=new StreamResult(new FileOutputStream(file));
            transformerHandler.setResult(result);
            AttributesImpl attr=new AttributesImpl();
                transformerHandler.startElement("","","bookstore",attr);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (SAXException e) {
        e.printStackTrace();
    }
    }
}
