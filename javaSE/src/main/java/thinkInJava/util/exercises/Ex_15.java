package thinkInJava.util.exercises;

import thinkInJava.util.SlowMap;

import java.util.Map;

/**
 * Created by ALEX on 24.02.16.
 */
public class Ex_15 {
    public static final String input="A dfd a is is";
    public static void main(String[] args) {
        System.out.println(wordCount(input.split(" ")));
    }
    public static Map<String, Integer> wordCount(String... input) {
        Map<String, Integer> counter=new SlowMap<String, Integer>();
        for(String s: input) {
            Integer number=counter.get(s);
            counter.put(s, number == null ? 1 : number+ 1);
        }
        return counter;
    }
}
