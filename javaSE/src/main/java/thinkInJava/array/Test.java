package thinkInJava.array;

import java.util.Arrays;

/**
 * Created by ALEX on 23.07.2016.
 */
public class Test {
    int [][][] b;
    private void m() {

    }
    public static void main(String[] args) {
        E[] a1={new E(), new E()};
        E[] a2={new E(), new E()};
        System.out.println(Arrays.equals(a1, a2));
    }
}
class E {
    private int s=2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        E e = (E) o;

        return s == e.s;

    }

    @Override
    public int hashCode() {
        return s;
    }
}