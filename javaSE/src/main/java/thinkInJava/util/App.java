package thinkInJava.util;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ALEX on 11.02.16.
 */
public class App {
    public static void main(String[] args) {
        Collection<String> c = new CopyOnWriteArrayList<>(Arrays.asList("dfk"));
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        } catch(ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
class A {
    void f() {
        System.out.println("f");
    }
    static void f(int a) {
        System.out.println(a);
    }
    static void g() {
        System.out.println("g");
    }
}

