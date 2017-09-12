package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_15 {
    public static void main(String[] args) {
        new B().getA("kdf").print();
    }

}
class A {
    private int i;
    private String s;
    A() {
    }
    A(int i) {
        this.i=i;
    }
    A(String s) {
        this.s=s;
    }
    void print() {
        System.out.println(s);
    }
}
class B {
    String b="44";
    public A getA() {
        return new A() {


        };
    }
    public A getA(int i) {
        return new A(i) {

        };
    }
    public A getA(String s) {
        return new A(s) {
            private String m=b;
            {
                System.out.println("uhaha");
            }

        };
    }
}
