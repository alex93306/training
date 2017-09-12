package thinkInJava.array.ex;

/**
 * Created by ALEX on 26.07.2016.
 */
public class Ex_3 {
    private double[][] createArray(int xSize, int ySize, double begging, double end ) {
        double[][] array=new double[xSize][ySize];
        double increment = (end - begging)/(xSize * ySize);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]+=increment;
            }
        }
        return array;

    }

    public static void main(String[] args) {
        
    }
}
