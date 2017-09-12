package thinkInJava.threads;

/**
 * Created by ALEX on 16.08.2016.
 */
class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Received: " + n);
        valueSet=false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet=true;
        System.out.println("Sended: " + n);
        notify();
    }
}
class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            q.put(i++);
        }
    }
}
class Consumer implements Runnable {
    private Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
class PC {
    public static void main(String[] args) {
        Q q=new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("For stop pressed CTRL + C");
    }
}