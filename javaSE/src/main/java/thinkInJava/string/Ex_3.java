package thinkInJava.string;

import java.util.Formatter;

/**
 * Created by ALEX on 05.12.15.
 */
public class Ex_3 {
    public static void main(String[] args) {
        System.out.printf("Hello %s", "alex");
        new Formatter(System.err).format("Hello %s", "alex");
    }
}

