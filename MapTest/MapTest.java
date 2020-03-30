package MapTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        //map输出数据的形式与Collection比较出现频率不高，但仍需要熟练使用学会此标准步骤，代码必须掌握
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Hello");
        map.put(2,"World");
        Set<Map.Entry<Integer,String>> set=map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator=set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> me=iterator.next();
            System.out.println(me.getKey()+"="+me.getValue());
        }
        //之前使用的都是系统类（Integer）,实际上也可以用自定义的类作为key，具体操作:
        //这个时候要记得复写Object类中的hashCode（）与equals（）方法
        //实际开发中，对于Map集合中的key的类型不是使用String就是使用Integer，这些系统类都帮助用户复写好这两个方法了
        Map<Person,String> map1=new HashMap<Person, String>();
        map1.put(new Person("zhangsan"),new String("zs"));
        System.out.println(map1.get(new Person("zhangsan")));
        //TreeMap表示可以排序的Map子类，他是按照key的内容来排序的。

    }
}
class Person{
    private String name;
    public Person(String name){
        this.name=name;
    }
    public String toString(){
        return "姓名："+this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
