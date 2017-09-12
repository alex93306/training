package thinkInJava.inner;

/**
 * Created by ALEX on 28.11.15.
 */
public class Ex_21 {
    public static void main(String[] args) {
        I3.Inner.g(new I3() {
            @Override
            public void f() {
                System.out.println("ffffffff");
            }
        });
    }
}
interface I3 {
    void f();
    static class Inner {
        static void g(I3 i) {
            i.f();
        }
    }
}