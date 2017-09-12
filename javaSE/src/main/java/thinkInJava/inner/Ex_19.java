package thinkInJava.inner;

/**
 * Created by ALEX on 28.11.15.
 */
public class Ex_19 {
    public static void main(String[] args) {
        Outer5.Inner.Inner2 oii=new Outer5.Inner.Inner2();
        oii.f();

    }
}
class Outer4 {
    class Inner {
        class Inner2 {
            void f() {
                System.out.println("ffff");
            }
        }
    }
}
class Outer5 {
    static class Inner {
        static class Inner2 {
            static void f() {
                System.out.println("nested fff");
            }
        }
    }
}

