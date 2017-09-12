package thinkInJava.inner;

import thinkInJava.inner.ex_6.Interface;
import thinkInJava.inner.ex_6_2.Outer;

/**
 * Created by alex on 27.11.2015.
 */
public class Ex_6  extends Outer{
    public static final Interface show() {
        return new Outer().new ImpleInterface();
    }
    public static void main(String[] args) {

    }
}
