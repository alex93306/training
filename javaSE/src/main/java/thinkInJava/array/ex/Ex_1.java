package thinkInJava.array.ex;

import java.util.Arrays;

/**
 * Created by ALEX on 26.07.2016.
 */
public class Ex_1 {
    public static void main(String[] args) {
        f(new int[]{3, 3, 5});
        f(new int[]{3,2 ,5});
    }
    public static void m(int... a) {}
    public static void f(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
