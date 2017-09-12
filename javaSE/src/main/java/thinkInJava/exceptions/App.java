package thinkInJava.exceptions;

/**
 * Created by ALEX on 01.12.15.
 */
public class App {
    public static void main(String[] args) {
        try {
            new A().g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    void f() throws Exception {
        throw new Exception("throw in f");
    }
    void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
}