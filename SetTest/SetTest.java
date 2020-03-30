package SetTest;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        List<String> all=new ArrayList<>();
        all.add("zhangsan");
        Iterator<String> iter=all.iterator();
        while (iter.hasNext()){
            String str=iter.next();
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