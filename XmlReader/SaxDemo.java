package XmlReader;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxDemo {
    public static void parseDemo(){
        SAXParserFactory factory=SAXParserFactory.newInstance();

        try {
            SAXParser parser=factory.newSAXParser();
            SaxParseHandler handler=new SaxParseHandler();
            parser.parse("books.xml",handler);
            System.out.println("共有"+handler.getBookList().size()+"本书");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
