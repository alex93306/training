package thinkInJava.util.exercises;

import thinkInJava.util.AssociativeArray;

/**
 * Created by ALEX on 24.02.16.
 */
public class Ex_13 {
    public static final String input="A dfd a is is";
    public static void main(String[] args) {
        System.out.println(wordCount(input.split(" ")));
    }
    public static AssociativeArray<String, Integer> wordCount(String... input) {
        AssociativeArray<String, Integer> counter=new AssociativeArray<String, Integer>(input.length);
        for(String s: input) {
            Integer number=counter.get(s);
            counter.put(s, number == null ? 1 : number+ 1);
        }
        return counter;
    }
}
