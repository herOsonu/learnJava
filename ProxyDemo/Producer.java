package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IProduver{

}

public class Producer implements IProduver{
}
class Client{
    Producer producer=new Producer();
    /*
    * 动态代理
    * 作用：不修改源码的基础上对方法增强
    * 分类：基于接口的和基于子类的
    * 接口的：     ｛设计的类：Proxy  提供者jdk官方｝
    * 如何创建代理对象： 使用Proxy类中的newProxyInstance方法
    * 要求：至少实现一个对象
    * newProxyInstance方法的参数：
    * ClassLoader:类加载器  他是用于加载代理对象字节码的，写的是被代理对象的类加载器。
    * Class【】字节码数组   他是让代理对象和被代理对象有相同方法
    * InvocationHandler：用于提供增强的代码  他是让我们写如何代理，我们一般都是写一个该接口的实现类，通常抢矿下都是匿名内部类，不是必须的，谁用谁写
    * */
    IProduver proxyProducer= (IProduver) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
        /**
         * 作用：执行被代理对象的任何接口方法都会经过该方法
         * @param o  代理对象的引用
         * @param method  当前执行的方法
         * @param objects 当前方法的参数
         * @return   方法相同的返回值
         * @throws Throwable
         */
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

            return method.invoke(o,objects);
        }
    });
}
