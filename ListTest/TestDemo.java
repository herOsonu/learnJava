package ListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//有序可重复，集合保存最多的是简单java类
//vector是旧的子类，jdk1.2加入，异步处理性能高，非线程安全
//LinkedList是纯粹的链表实现，封装的是链表O（n）为n,ArrayListO(n)为1
public class TestDemo {
    public static void main(String[] args) {
        List<Person> all=new Vector<>();
        all.add(new Person("张三",12));
        all.add(new Person("李四",13));
        all.add(new Person("孙武",16));
        all.add(new Person("赵柳",18));
        for(int i=0;i<all.size();i++){
            System.out.println(all.get(i));
        }

        List<String> allArrayList=new ArrayList<>();
        allArrayList.add("zhangsan");
        Iterator<String> iter=allArrayList.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
        }

    }
}
class Person{
    private String name;
    private Integer age;//Integer能操作空

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }
}
