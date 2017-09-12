package thinkInJava.inner;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_12 {
    public static void main(String[] args) {
        new Outer2().h();
    }
}
class Outer2 {
    private int a=10;
    private void f() {
        System.out.println("dfk");
    }
    public void h() {
         new Object() {
           void g() {
               a++;
               f();
           }

        }.g();
        System.out.println(a);
    }

}

/*
Create a class with a private field and a private method.
        Create an inner class with a method that modifies the outer-class
        field and calls the outer-class method. In a second outer-class method,
        create an object of the inner class and call its method,
        then show the effect on the outer-class object.*/
