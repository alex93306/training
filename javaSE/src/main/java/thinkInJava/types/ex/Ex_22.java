package thinkInJava.types.ex;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by alex on 14.07.2016.
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object result = method.invoke(proxied, args);
        long duration = System.nanoTime() - start;
        System.out.println("Method-call times: " + duration);
        return result;
    }
}
public class Ex_22 {
    static void consumer(Interface i) {
        i.doSomething();
        i.somethingElse("bobobo");
    }

    public static void main(String[] args) {
        /*RealObject real= new RealObject();
        consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);*/
    }
}
