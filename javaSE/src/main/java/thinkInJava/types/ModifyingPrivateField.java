package thinkInJava.types;

import java.lang.reflect.Field;

/**
 * Created by alex on 15.07.2016.
 */
class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I’m totally safe";
    private String s2 = "Am I safe?";
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}
public class ModifyingPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pi=new WithPrivateFinalField();
        System.out.println(pi);
        Field f=pi.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pi)" + f.getInt(pi));
        f.setInt(pi, 34);
        System.out.println(f.getInt(pi));
        f=pi.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pi)" + f.get(pi));
        f.set(pi, "bbbbbb");
        System.out.println(f.getInt(pi));

    }
}
