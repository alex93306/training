package thinkInJava.util.exercises;

import java.util.*;

/**
 * Created by ALEX on 16.02.16.
 */
public class Ex_9 {
        public static void main(String[] args) {
            SortedSet<String> sortedSet=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
            Collections.addAll(sortedSet,"two", "One", "second", "one");
            System.out.println(sortedSet);
            System.out.println(sortedSet.size());
        }
}

class RamdomGenerator {
    private Random random=new Random();

    public int next() {
        return random.nextInt();
    }

}
