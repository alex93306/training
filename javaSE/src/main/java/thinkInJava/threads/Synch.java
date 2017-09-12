package thinkInJava.threads;

/**
 * Created by ALEX on 14.08.2016.
 */
class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interepted");
        }
        System.out.println("]");
    }
}
class Caller implements Runnable {
    private String msg;
    private Callme target;
    Thread t;

    public Caller(Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
public class Synch {
    public static void main(String[] args) {
        Callme target=new Callme();
        Caller ob1 = new Caller(target, "Welcome");
        Caller ob2 = new Caller(target, "sync");
        Caller ob3 = new Caller(target, "wolld!");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interepted");
        }
    }
}
