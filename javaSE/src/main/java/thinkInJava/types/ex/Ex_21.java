package thinkInJava.types.ex;

class SimpleProxy implements Interface {

    private Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long start = System.nanoTime();
        proxied.doSomething();
        long duration = System.nanoTime() - start;
        System.out.println("Method-call time: " + duration);
    }

    @Override
    public void somethingElse(String arg) {
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long duration = System.nanoTime() -start;
        System.out.println("Method-call time: " + duration);

    }
}

public class Ex_21 {
    public static void consumer(Interface i) {
        i.doSomething();
        i.somethingElse("bonono");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
