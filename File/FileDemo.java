package File;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;

public class FileDemo {
    public static void main(String[] args) {
        //目标文件
        File file=new File("D:"+File.separator+"learnFile"+File.separator+"demo.txt");
        //判断文件父路径是否存在
        /*
        * 如果文件有多级目录，要先创建目录再创建文件
        * */
        if(!file.getParentFile().exists()){
            //创建父路径
            file.getParentFile().mkdirs();
            System.out.println("创建文件所在目录成功！");
        }else{
            System.out.println("文件所在目录已存在");
        }
        if(!file.exists()){
            try {
                //创建文件
                file.createNewFile();
                System.out.println("文件创建成功");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            //删除文件
            file.delete();
            System.out.println("文件删除成功");
        }
        try {
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
        //length（）取得文件大小
        if(file.exists()&&file.isFile()){
            System.out.println("文件大小"+MyMath.round((file.length()/(double)1024/(double)1024),2));
        }
        System.out.println(MyMath.round(1.123456,3));
        //lastModified()最后一次修改日期
        if(file.exists()&&file.isFile()){
            System.out.println("最后修改日期："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
        }
        //listFiles()列出本目录的第一级信息（用递归实现所有目录）
        File file1=new File("d:"+File.separator);
        if(file1.exists()&&file1.isDirectory()){
            File[] result=file1.listFiles();
            for(File i:result){
                System.out.println(i);
            }
        }
        System.out.println("***************************************");
        MyMath.listDir(new File("D:"+File.separator));
        System.out.println("执行完毕");
        /*
        * 线程阻塞问题：
        * 现在所有的代码都是在main线程下进行的，如果列出的操作不完成，那么接下来的操作都无法进行，这种耗时的操作导致线程的阻塞，此时如果不想让这种现象出现，最好在产生一个新的线程进行处理*/
        new Thread(()->{
            File file2=new File("d:"+File.separator);
            MyMath.listDir(file2);
        },"列出线程").start();
        System.out.println("*******************************************");
        try {
            FileDirectory.directory(new File("d:"+File.separator));
            System.out.println("success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        * RandomAccessFile,java文件模型在硬盘上的文件是byte存储的，文件指针打开文件时pointer=0，写方法raf.write（int）只写一个字节
        * */

       File file2=new File("d:"+File.separator+"Demo.txt");
        try {
            if(!file2.exists()){
                file2.createNewFile();
            }
            RandomAccessFile raf=new RandomAccessFile(file2,"rw");
            System.out.println(raf.getFilePointer());
            raf.write('A');//只写一个字节？
            System.out.println(raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class MyMath{
    public static double round(double num,int scale){
        return Math.round(num*Math.pow(10,scale))/Math.pow(10,scale);
    }
    public static void listDir(File file){
        if(file.isDirectory()){
            File[] result=file.listFiles();
            if(result!=null) {
                for (int i = 0; i < result.length; i++) {
                    listDir(result[i]);
                }
            }
        }
        System.out.println(file);

    }
}