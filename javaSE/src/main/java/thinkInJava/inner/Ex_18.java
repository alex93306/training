package thinkInJava.inner;

/**
 * Created by ALEX on 28.11.15.
 */
public class Ex_18 {


    public static void main(String[] args) {
        Outer3.Inner oi=new Outer3.Inner(25);
        oi.f();

    }
}
class Outer3 {
    static class Inner {
        private int i=34;
        Inner(int i) {
            this.i=i;
        }
        void f() {
            System.out.println(i);
        }
        static void j() {
            System.out.println("tttt");
        }

    }
}
