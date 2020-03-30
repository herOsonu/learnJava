package SimpleDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SimpleDemo {
    public static void main(String[] args)throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today=sdf.format(date);
        System.out.println(today);
        String day="2020年03月14号13:30";
        SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd号HH:MM");
        System.out.println(df.parse(day));
        Integer[] nums=new Integer[10];
        for(int i=0;i<nums.length;i++){
            nums[i]=(int) (Math.random()*10);
        }
        System.out.println(Arrays.toString(nums));
    }
}
