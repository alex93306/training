package thinkInJava.generics;


import java.util.*;

/**
 * Created by alex on 07.12.2015.
 */
public class App {
    public static void main(String[] args) {

    }


}

/*class MixinProxy implements InvocationHandler {
    private Map<String, Object> delegateMap=new HashMap<>();

    MixinProxy(Map<Object, Class<?>> map) {
        for (Map.Entry<Object, Class<?>> entry: map.entrySet()) {
            Class<?> clazz=entry.getValue();
            Method[] methods=clazz.getMethods();
            for (Method m:methods) {
                delegateMap.put(m.getName(), entry.getKey());
            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object obj=delegateMap.get(methodName);
        return method.invoke(obj, args);
    }

    public static Object newInstanse(Map<Object, Class<?>> map){
        Class[] interfaces=new Class[map.size()];
        for (Map.Entry<Object, Class<?>> entry: map.entrySet()
        ){
            
        }
    }
}*/

interface TimeStamped { long getStamp(); }

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp; }
}

interface SerialNumbered { long getSerialNumber(); }
class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() { return serialNumber; }
}
interface Basic {
    public void set(String val);
    public String get();
}
class BasicImp implements Basic {
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Draw circle");
    }
}
class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Triangle");
    }
}

abstract class Decorator extends Shape {
    protected Shape shape;

    public Decorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    void draw() {
        shape.draw();
    }
}


class RedBorder extends Decorator {
    RedBorder(Shape shape) {
        super(shape);
    }
    void drawBorder() {
        System.out.println("border");
    }
}

class BackgroundShape extends Decorator {

    public BackgroundShape(Shape shape) {
        super(shape);
    }


}
interface I<T,E extends Exception> {
    void f(T arg) throws E;
}
class IIml implements I<String, Exception> {

    @Override
    public void f(String arg) throws Exception {

    }
}
class GenericSetter<T> {
    void set(T arg) {
        System.out.println("Generic");
    }
}
class DerivedGs extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("derived");
    }
}

class Base {}
class Derived extends Base{}
class Failure1 extends Exception {}


interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for(Processor<T, E> processor: this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }

}


class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List list) {
        list.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dog1=new ArrayList<>();
        oldStyleMethod(dog1);
        List<Dog> dog2= Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dog2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Pet {

}
class Cat extends Pet{}
class Dog extends Pet{}