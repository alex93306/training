package thinkInJava.array.ex;

import java.util.Arrays;

/**
 * Created by ALEX on 31.07.2016.
 */
public class Ex_6 {
    public static BerylliumSphere[][] createArray(int x, int y) {
        BerylliumSphere[][] arra=new BerylliumSphere[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arra[i][j]=new BerylliumSphere();
            }
        }
        return arra;

}

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(2, 4)));
    }
}
class  BerylliumSphere {

}
