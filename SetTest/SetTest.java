package SetTest;

import java.util.*;

//无序不重复,没有对Collection扩充（List扩充了get方法）,两个子类（HashSet、TreeSet）
public class SetTest {
    public static void main(String[] args) {
        Set<Person> set=new HashSet<Person>();
        set.add(new Person("zhangsan",18));
        set.add(new Person("lisi",15));
        Iterator<Person> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person() {
    }

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

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}