package thinkInJava.generics.ex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEX on 31.07.2016.
 */
public class Ex_29 {
    public static void main(String[] args) {

    }
    public static void f(Holder<List<?>> list) {
        List<?> li=list.getValue();
        list.setValue(li);
        list.setValue(new ArrayList<String>());
    }
    public static void g(List<Holder<?>> list) {
        Holder<?> holder=list.get(0);
//        holder.setValue("kdsf");
        list.add(new Holder<Object>());
    }
}
class Holder<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}