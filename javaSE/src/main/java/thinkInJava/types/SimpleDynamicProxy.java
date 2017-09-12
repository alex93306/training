package thinkInJava.types;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by alex on 13.07.2016.
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        if(args != null)
            for(Object arg : args)
                System.out.println(" " + arg);
        return method.invoke(proxied, args);
    }
}
public class SimpleDynamicProxy {

    public static void consumer(Interface i) {
        i.doSomething();
        i.somethingElse("bonono");
    }

    public static void main(String[] args) {
        RealObject realObject=new RealObject();
        consumer(realObject);
        System.out.println("--------------");
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(realObject));
        consumer(proxy);
    }



}
