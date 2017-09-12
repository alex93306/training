package thinkInJava.generics.ex;

/**
 * Created by ALEX on 03.08.2016.
 */
public class Ex_34 {
    public static void main(String[] args) {

    }
}
abstract class Generic<T> {
    public abstract T set(T arg);
    public T call(T t) {
        return set(t);
    }
}
class Derived extends Generic<Derived> {

    @Override
    public Derived set(Derived arg) {
        return arg;
    }
}