package ComparableDemo;

import java.util.*;

public class ComaprableDemo {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        Random random=new Random();
        list.add(new Person(random.nextInt(1000),"zhagnsan"));
        list.add(new Person(random.nextInt(1000),"lisi"));
        list.add(new Person(random.nextInt(1000),"sunwu"));
        for(Person per:list){
            System.out.println("id:"+per.getId()+" name:"+per.getName());
        }
        Collections.sort(list);
        System.out.println();
        for(Person per:list){
            System.out.println("id:"+per.getId()+" name:"+per.getName());
        }
        System.out.println();
        Collections.sort(list,new CompareName());
        for(Person per:list){
            System.out.println("id:"+per.getId()+" name:"+per.getName());
        }

    }
}
class Person implements Comparable<Person>{
    private Integer id;//此处id为Integer类型，如果为String则排序会按照String类型比较
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
class CompareName implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName())*-1;
    }
}
