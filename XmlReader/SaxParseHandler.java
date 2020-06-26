package XmlReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;


public class SaxParseHandler extends DefaultHandler {
    int bookIndex=0;
    String value=null;
    Book book=null;
    private ArrayList<Book> bookList=new ArrayList<>();
    public ArrayList<Book> getBookList(){
        return bookList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //开始解析book元素的属性
        super.startElement(uri, localName, qName, attributes);
        //已知book元素的属性名称
        if(qName.equals("book")){
            bookIndex++;
            book=new Book();
            //String value=attributes.getValue("id");
            //System.out.println("book的属性值是："+value);
            //如果不知道book元素的属性名称，如何获取属性名跟属性值呢
            int num=attributes.getLength();
            for(int i=0;i<num;i++){
                System.out.print("book元素的第"+(i+1)+"个"+"属性名是："+attributes.getQName(i));
                System.out.println("---属性值是："+attributes.getValue(i));
                if(attributes.getQName(i).equals("id")){
                    book.setId(attributes.getValue(i));
                }
            }
        }
        if(!qName.equals("book")&&!qName.equals("bookstore")){
            System.out.print("节点是"+qName+"---");

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //判读一本书是否遍历结束
        if(qName.equals("book")){
            System.out.println("第"+bookIndex+"本书遍历结束");
            bookList.add(book);
            book=null;
        }else if(qName.equals("name")){
            book.setName(value);
        }else if(qName.equals("author")){
            book.setAuthor(value);
        }else if(qName.equals("year")){
            book.setYear(value);
        }else if(qName.equals("price")){
            book.setPrice(value);
        }else if(qName.equals("language")){
            book.setLanguage(value);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value=new String(ch,start,length);
        if(!value.trim().equals("")){
            System.out.println(value);
        }
    }
}
//"=="是判断两个变量或实例是不是指向同一个内存空间。"equals"是判断两个变量或实例所指向的内存空间的值是不是相同。

