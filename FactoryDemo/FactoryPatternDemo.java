package FactoryDemo;
//泛型+反射解决工厂问题
interface IShape {
    void draw();
}
interface IMessage{
    void print();
}
class Phone implements IMessage{
    public void print(){
        System.out.println("output Message");
    }
}
class Rectangle implements IShape {
    public void draw(){
        System.out.println("Inside rectangle::draw () method.");
    }
}
class Square implements IShape {
    public void draw(){
        System.out.println("Inside square::draw() method.");
    }
}
class Circle implements IShape {
    public void draw(){
        System.out.println("Inside circle::draw() method.");
    }
}
class SimpleFactoryPattern {
    //简单工厂模式就是用来创建同一类对象的不同实例。
    public <T>T getInstance(String shapeType){
        /*if(shapeType!=null&&shapeType!=""){
            if(shapeType.equals("Rectangle")){
                return new Rectangle();
            }else if(shapeType.equals("Square")){
                return new Square();
            }else if(shapeType.equals("Circle")){
                return new Circle();
            }
        }
        return null;*/
        T obj=null;
        try {

           obj=(T)Class.forName(shapeType).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
public class FactoryPatternDemo {
    public static void main(String[] args) {
        SimpleFactoryPattern fp=new SimpleFactoryPattern();
        IShape IShape =fp.getInstance("FactoryDemo.Circle");
        IShape.draw();
        IMessage sendMessage=fp.getInstance("FactoryDemo.Phone");
        sendMessage.print();
    }
}
