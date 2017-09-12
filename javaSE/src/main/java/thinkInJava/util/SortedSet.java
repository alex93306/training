package thinkInJava.util;

import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by ALEX on 11.02.16.
 */
public class SortedSet {
    public static void main(String[] args) {
        java.util.SortedSet<String> sortedSet=new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        System.out.println(sortedSet);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        System.out.println(sortedSet.headSet("four"));
        System.out.println(sortedSet.tailSet("six"));
    }
}
