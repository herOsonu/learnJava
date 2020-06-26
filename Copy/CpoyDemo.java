package Copy;

import java.io.*;

public class CpoyDemo {
    public static void main(String[] args)throws IOException {
      PrintStream ps=new PrintStream("d:"+File.separator+"Demo.txt");
      ps.write("100111".getBytes());

    }
}
