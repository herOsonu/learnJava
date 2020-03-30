package ListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
