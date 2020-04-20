package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        Date date=new Date();
        System.out.println(date.getClass());//反射核心是通过对象找到对象身后的组成（类...）
        //三种取得类对象的方式
        //1.通过Object类中的getClass（）方法取得Class类对象
        Class<?> cls=new Date().getClass();//此处泛型用“？”，反射的泛型可以理解为Object
        System.out.println(cls.getName());
        //2."类.class"直接根据某一具体的类来取得Class类的实例化对象
        Class<?> cls1=Date.class;//不需要实例化Date类对象了
        //3.使用Class类提供的方法,前两种都有一个缺点（都需要import）
        Class<?> cls2=Class.forName("java.util.Date");//直接使用字符串描述需要使用的类
        //以上三种方式，除了第一种要产生Date类实例化对象外，其余两种都不需要产生实例化对象。
        Object obj=cls.getDeclaredConstructor().newInstance();
        //除了关键字new之外，对于对象的实力化对象有了第二种做法：通过反射进行

        //反射调用方法
        Class<?> clss=Person.class;
        String attribute="name";
        String value="zhagnsan";
        Object objj=clss.getDeclaredConstructor().newInstance();
        Method setMethod=clss.getMethod("set"+upper(attribute),String.class);//String.class方法参数
        setMethod.invoke(objj,value);
        Method getMethod=clss.getMethod("get"+upper(attribute));
        Object ret=getMethod.invoke(objj);
        System.out.println(ret);//好处是不在局限于某一具体对象，而是可以通过Object类型进行所有累的方法调用

        //反射成员调用,两种取得属性的操作方法
        //field中的两个重要方法
        Class<?> clsss=Person.class;
        {
            Field field[]=clsss.getFields();//取得全部属性
            for(Field field1:field){
                System.out.println(field1);
            }
        }
        Object objjj=clsss.getDeclaredConstructor().newInstance();
        Field nameField=clsss.getDeclaredField("name");
        nameField.setAccessible(true);//在AccessibleObject类中提供有一个方法，（动态设置封装）public void setAccessible(boolean flag),取消了封装
        nameField.set(objjj,"zhangsan");//不能访问private属性
        //Filed中有一个取得属性类型的方法 getName getSimpleName，与Method类中的invoke()结合在一起，就可以非常灵活的编写程序了
        Class<?> cl=Person.class;
        Object ob=cl.getDeclaredConstructor().newInstance();
        Field field=cl.getDeclaredField("name");
        System.out.println(field.getType().getSimpleName());
        System.out.println(field.getType().getName());
        System.out.println(field.getType());
        Method setMethod1=cl.getMethod("setName",field.getType());
        setMethod.invoke(ob,"lisi");
        Method getMethod2=cl.getMethod("getName");
        System.out.println(getMethod2.invoke(ob));




    }
    public static String upper(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);

    }
}

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
