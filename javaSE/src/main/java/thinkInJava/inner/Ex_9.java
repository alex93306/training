package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_9 {
    public static void main(String[] args) {
        getI().f();
    }
    public static I getI() {
        class IImpl implements I {
            @Override
            public void f() {
                System.out.println("fff");
            }
        }
        return new IImpl();
    }
}
interface I {
    void f();
}
