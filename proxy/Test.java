package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        IMessage subject=(IMessage) new ProxySubject().bind(new RealMessage());
        subject.eat("预想肉丝");
    }
}
interface IMessage{
    void eat(String str);
}
class RealMessage implements IMessage{
    @Override
    public void eat(String str) {
        System.out.println("开饭了,我要吃"+str);
    }
}
class ProxySubject implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * invoke（）表示的是调用执行的方法，
     * @param o  表示的是被代理的对象信息
     * @param method 返回的是被调用的对象方法
     * @param objects 方法中节后到的参数
     * @return  方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        this.clear();
        System.out.println(method);
        System.out.println(Arrays.toString(objects));
        return null;
    }
    public void clear(){
        System.out.println("ProxySubject shoushiwankuai ");
    }
}
