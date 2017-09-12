package thinkInJava.types;

/**
 * Created by alex on 15.07.2016.
 */
class B implements Interface1 {
    public void f() {
        System.out.println("fff");
    }
    private void g() {
        System.out.println("private void g");
    }
    protected void h() {
        System.out.println("default access h");
    }
}
public class HiddenB {
    public B getB() {
        return new B();
    }
}