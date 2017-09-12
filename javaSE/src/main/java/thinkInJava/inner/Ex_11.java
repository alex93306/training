package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_11 {
    public static void main(String[] args) {
    new Outer().getI();

    }

}
class Outer {
    private class IImpl implements I {

        @Override
        public void f() {
            System.out.println("fff");
        }
    }
    public I getI() {
        return new IImpl();
    }
}
