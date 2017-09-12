package headfirst.singleton2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ALEX on 29.07.2017.
 */
public class MySingleton {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 34};
        System.out.println(Arrays.toString(a));
        List<Integer> b = Arrays.asList(a);
        System.out.println(b);
        b.set(1, 0);
        System.out.println(b);
        System.out.println(Arrays.toString(a));
        a[0] = 0;
        System.out.println(Arrays.toString(a));
        System.out.println(b);

    }

    private static void f(Integer... a) {
        System.out.println(Arrays.toString(a));
    }

    private static void test(Predicate<Integer> p) {
        System.out.println(p.test(5));
    }
}
class A {
    private static A instance = new A();
    private A() {}

    public static A getInstance() {
        return instance;
    }
}
