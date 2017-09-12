package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_10 {
    public static void main(String[] args) {
        m(false);
    }
    public static void m(boolean b) {
        if(b) {
            class IImpl implements I {

                @Override
                public void f() {
                    System.out.println("ffff");
                }
            }
            new IImpl().f();
        }

    }

}

