package EnumTest;
//1.5之前没有枚举多例设计模式
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Color.getInstance(0));
        //1.5之后的枚举
        System.out.println(Color1.RED);
        for(Color1 temp:Color1.values()){
            System.out.println(temp.ordinal()+"="+temp.name());//枚举跟多例的区别在这个values方法上
            //enum是一个关键字，使用enum定义的类本质上是一个类继承了Enum这个抽象类
        }
    }
}
class Color{
    private static final Color RED=new Color("RED");
    private static final Color GREEN=new Color("GREEN");
    private static final Color BLUE=new Color("BLUE");
    private String title;
    private Color(String title){
        this.title=title;
    }
    public static Color getInstance(int ch){
        switch (ch){
            case  0:return RED;
            case  1:return GREEN;
            case  2:return BLUE;
            default:return null;
        }
    }
    public String toString(){
        return this.title;
    }
}
enum Color1{
    RED,GREEN,BLUE
}