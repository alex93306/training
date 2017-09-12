package thinkInJava.types;

/**
 * Created by alex on 13.07.2016.
 */
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
public class SimpleDemoProxy {
}
