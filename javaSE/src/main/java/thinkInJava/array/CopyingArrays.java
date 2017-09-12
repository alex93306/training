package thinkInJava.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ALEX on 27.07.2016.
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i=new int[7];
        int[] j=new int[9];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
    }
}
class A {

}
class ComparingArrays {
    public static void main(String[] args) {
        Integer[] a1=new Integer[10];
        int[] a2=new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        A[] a=new A[10];
        Arrays.fill(a, new A());
        Arrays.sort(a, Collections.reverseOrder());

    }
}
class StringSorting {
    public static void main(String[] args) {
        String[] sa={"sdf", "a", "A", "ur", "s"};
        System.out.println("Before sorting: " + Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("After sorting: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.<String>reverseOrder());
        System.out.println("Reverse sort: " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-ins" + Arrays.toString(sa));
    }
}
class ArraySearching {
    public static void main(String[] args) {
        int[] a={2, 5, 5, 14};
        System.out.println(Arrays.binarySearch(a,7));

    }
}
