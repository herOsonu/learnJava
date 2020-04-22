package File;

import java.io.File;
import java.io.IOException;

public class FileDirectory {
    public static void directory(File dir)throws IOException {
        if(!dir.exists()){
            throw new IllegalArgumentException("目录"+dir.getParentFile()+"不存在");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }
        File[] result=dir.listFiles();
        for(File r:result){
            System.out.println(r);
        }
    }
    //列出所有文件的练习
    public static void listAllDirectory(File file){
        if(file.isDirectory()){
            File[] result=file.listFiles();
            if(result!=null){
                for(int i=0;i<result.length;i++){
                    listAllDirectory(result[i]);
                }
            }
        }
        System.out.println(file);
    }
}
