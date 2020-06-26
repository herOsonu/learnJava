package InetAddressFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class InetAddressDemo {
    public static void main(String[] args) throws Exception{
        //获取本机的InetAddress实例
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        byte[] bytes=address.getAddress();//获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP："+ Arrays.toString(bytes));
        //创建一个url实例
        URL imooc=new URL("http://www.imooc.com");
        URL url=new URL(imooc,"/index.html?username=tom#test");//?传递参数（jsp）,#表示锚点
        System.out.println("协议："+url.getProtocol());
        System.out.println("主机："+url.getHost());
        System.out.println("端口："+url.getPort());//创建实例时没有指定端口号，默认指定端口号f返回值为-1
        System.out.println("文件路径："+url.getPath());
        System.out.println("文件名："+url.getFile());
        System.out.println("相对路径"+url.getRef());//就是锚点后面的内容
        System.out.println("查询字符串："+url.getQuery());//参数
        urlOpenStream();
    }

    //使用url读取网页内容
    public static void urlOpenStream(){
        try {
            URL url=new URL("http://www.baidu.com");
            InputStream inputStream=url.openStream();
            InputStreamReader reader=new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(reader);
            String data=bufferedReader.readLine();
            while (data!=null){
                System.out.println(data);
                data=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
