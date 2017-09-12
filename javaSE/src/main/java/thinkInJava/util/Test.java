package thinkInJava.util;

/**
 * Created by ALEX on 27.02.16.
 */
public abstract class Test<C> {

    /**Name of test*/
    String name;

    public Test(String name) {
        this.name=name;
    }

    abstract int test(C container, TestParam tp);
}
