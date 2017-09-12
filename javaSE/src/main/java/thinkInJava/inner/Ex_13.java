package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_13 {
    public static void main(String[] args) {
        new Ex_13().getI().f();
    }
    public I getI() {
        return new I() {
            @Override
            public void f() {
                System.out.println("haha");
            }
        };
    }
}


