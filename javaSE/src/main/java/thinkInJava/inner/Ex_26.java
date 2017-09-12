package thinkInJava.inner;

/**
 * Created by ALEX on 29.11.15.
 */
public class Ex_26 {
    public static void main(String[] args) {

    }
}
class Outer6 {
    class Inner {
        Inner(int i) {

        }
    }

}
class Outer7 {
    class Inner extends Outer6.Inner {

        Inner(Outer6 o, int i) {
            o.super(i);
        }
    }
}
