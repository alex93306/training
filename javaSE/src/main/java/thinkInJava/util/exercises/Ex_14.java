package thinkInJava.util.exercises;

import java.util.*;

/**
 * Created by ALEX on 16.02.16.
 */
public class Ex_14 {
    public static void main(String[] args) {
        Properties properties2=new Properties();
        properties2.put("one", 1);
        Properties properties=new Properties(properties2);
        properties.put("two", "2");
        System.out.println(properties.getProperty("one"));


        test(new HashMap());
        test(new Properties());





    }
    public static void test(Map map) {
        System.out.println(map.getClass().getSimpleName());
        System.out.println(map);

    }

}
