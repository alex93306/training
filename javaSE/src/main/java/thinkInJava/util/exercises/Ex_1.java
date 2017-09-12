package thinkInJava.util.exercises;

import thinkInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ALEX on 08.02.16.
 */
public class Ex_1 {
    public static void main(String[] args) {
        List<String> countries= new ArrayList<String>(Countries.names(5));
        System.out.println(countries);
        Collections.shuffle(countries);
        System.out.println(countries);
        Collections.shuffle(countries);
        System.out.println(countries);
    }
}

