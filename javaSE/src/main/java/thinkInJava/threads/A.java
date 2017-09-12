package thinkInJava.threads;

/**
 * Created by ALEX on 16.08.2016.
 */
public class A {
    synchronized  void f(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " вошел в метод A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "пытается вызвать метод B.last");
        b.last();

    }
    synchronized void last() {
        System.out.println("B method A.last");
    }
}
class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод B.bar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " пытается вызвать A.last");
        a.last();
    }
    synchronized void last() {
        System.out.println("B методе А.last");
    }

}
class Deadlock implements Runnable {
    A a=new A();
    B b=new B();

    Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t=new Thread(this, "Соперничающий поток" );
        t.start();
        a.f(b);
        System.out.println("Назад в главный поток");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Назад в другой поток");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}