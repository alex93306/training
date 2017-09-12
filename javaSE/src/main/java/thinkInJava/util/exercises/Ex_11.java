package thinkInJava.util.exercises;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by ALEX on 10.04.2016.
 */
public class Ex_11 {
    public static void main(String[] args) {
        Queue<ContainInt> queue =new PriorityQueue<ContainInt>();
        for(int i=0; i<10; i++) {
            queue.add(new ContainInt());
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
class ContainInt implements Comparable<ContainInt> {
    private Random random=new Random();
    private int i;
    ContainInt() {
        i=random.nextInt(100);
    }

    public int compareTo(ContainInt o) {
        if(i > o.i) {
            return +1;
        }
        if (i == o.i) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "ContainInt{" +
                "i=" + i +
                '}';
    }
}