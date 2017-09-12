package thinkInJava.array.ex;

/**
 * Created by ALEX on 26.07.2016.
 */
public class Ex_2 {
    public static int[] createArray(int size) {
        int[] arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
