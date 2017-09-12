package thinkInJava.inner.ex_6_2;

import thinkInJava.inner.ex_6.Interface;

/**
 * Created by alex on 27.11.2015.
 */
public class Outer {

    protected class ImpleInterface implements Interface {
        public ImpleInterface() {

        }

        @Override
        public void f() {
            System.out.println("print f");
        }
    }
}
