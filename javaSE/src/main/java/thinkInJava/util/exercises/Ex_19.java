package thinkInJava.util.exercises;

import thinkInJava.util.SimpleHashMap;

import java.util.Map;

/**
 * Created by ALEX on 26.02.16.
 */
public class Ex_19 {
    public static void main(String[] args) {
        System.out.println(calc(Ex_13.input.split(" ")));
    }
    public static Map<String, Integer> calc(String[] args) {
        Map<String, Integer> map=new SimpleHashMap<String, Integer>();
        for(String s: args) {
            map.put(s, map.get(s)== null? 1: map.get(s) + 1);
        }
        return map;
    }
}
