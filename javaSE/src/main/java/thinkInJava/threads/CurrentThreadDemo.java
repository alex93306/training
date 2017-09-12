package thinkInJava.threads;

/**
 * Created by ALEX on 13.08.2016.
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println("Current thread: " + t);
        t.setName("My thread");
        System.out.println("After change thread name: " + t);
        try {
            for( int n=5; n>0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
