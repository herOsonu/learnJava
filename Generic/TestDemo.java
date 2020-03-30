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
