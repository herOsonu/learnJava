package XmlReader.Test;

import XmlReader.DomDemo;
import XmlReader.SaxDemo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XmlTest {
    /**
     * 初始化方法：
     * 用于申请资源，所有测试方法在执行之前都会先执行该方法
    * */
    @Before
    public void init(){
        System.out.println("init...");
    }
    /**
     * 释放资源的方法：
     * 在所有测试方法执行完后，都会自动执行该方法
    * */
    @After
    public void close(){
        System.out.println("close...");
    }
    /**
     * 判定结果：
     * 红色：失败
     * 绿色：成功
     * 一般会使用断言操作来处理结果
     * Assert.assertEquals(expected,reality)
    * */
    @Test
    public void testSaxParseHandler(){
        long start=System.currentTimeMillis();
        SaxDemo.parseDemo();
        start=System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-start+"-----------------------");
        start=System.currentTimeMillis();
        DomDemo.parseDemo();
        System.out.println(System.currentTimeMillis()-start+"------------------------");
    }

}
