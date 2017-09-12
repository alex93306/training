package thinkInJava.inner;

/**
 * Created by ALEX on 28.11.15.
 */
public class Ex_20 {
    public static void main(String[] args) {
        new I2.I2impl().f();
    }
}

interface I2 {
    void f();
    class I2impl implements I2 {

        @Override
        public void f() {
            System.out.println("I2 ff");
        }
    }
}