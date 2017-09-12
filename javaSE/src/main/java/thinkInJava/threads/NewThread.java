package thinkInJava.threads;

/**
 * Created by ALEX on 13.08.2016.
 */
public class NewThread implements Runnable {
    private String name;
    Thread t;
    public NewThread(String name) {
        this.name=name;
        t=new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for(int n=5; n>0; n--) {
                System.out.println(name + ": " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished.");
    }
}
class MultiThreadDemo {
    public static void main(String[] args) {
        NewThread t1=new NewThread("One");
        NewThread t2=new NewThread("Two");
        NewThread t3=new NewThread("Three");
   /*     try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            t3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.t.isAlive());
        System.out.println(t2.t.isAlive());
        System.out.println("main finished");
    }
}