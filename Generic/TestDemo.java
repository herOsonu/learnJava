package Generic;

public class TestDemo {
    public static void main(String[] args) {
        Point<Integer> point=new Point<>(1,2);
        System.out.println(point);
        IMessage iMessage=new MessageImpl(1.2);
        System.out.println(iMessage);
    }
    public void fun(MessageImpl<?> iMessage){
        System.out.println(iMessage.getT());
    }
}
class Point<T>{
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
interface IMessage<T>{
    void print(T t);
}
class MessageImpl<Double> implements IMessage<Double>{
    private Double t;

    @Override
    public String toString() {
        return "MessageImpl{" +
                "t=" + t +
                '}';
    }

    public MessageImpl(Double t) {
        this.t = t;
    }

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    @Override
    public void print(Double aDouble) {
        System.out.println(aDouble);
    }
}
//泛型类跟泛型方法的使用
    /*Class<T>的作用就是指明泛型的具体类型，而Class<T>类型的变量c，可以用来创建泛型类的对象。

        为什么要用变量c来创建对象呢？既然是泛型方法，就代表着我们不知道具体的类型是什么，也不知道构造方法如何，因此没有办法去new一个对象，但可以利用变量c的newInstance方法去创建对象，也就是利用反射创建对象。

        泛型方法要求的参数是Class<T>类型，而Class.forName()方法的返回值也是Class<T>，因此可以用Class.forName()作为参数。其中，forName()方法中的参数是何种类型，返回的Class<T>就是何种类型。在本例中，forName()方法中传入的是User类的完整路径，因此返回的是Class<User>类型的对象，因此调用泛型方法时，变量c的类型就是Class<User>，因此泛型方法中的泛型T就被指明为User，因此变量obj的类型为User。

        当然，泛型方法不是仅仅可以有一个参数Class<T>，可以根据需要添加其他参数。

        为什么要使用泛型方法呢？因为泛型类要在实例化的时候就指明类型，如果想换一种类型，不得不重新new一次，可能不够灵活；而泛型方法可以在调用的时候指明类型，更加灵活。*/
