package thinkInJava.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by alex on 13.07.2016.
 */
class A {

}
public class ShowMethods {
    public static void main(String[] args) {
        String word="notify";
        Class<?> c=A.class;
        Method[] methods=c.getMethods();
        Constructor[] constructors=c.getConstructors();
        Pattern p=Pattern.compile("\\w+\\.");
        if(word == null) {
            for(Method m: methods) {
                System.out.println(p.matcher(m.toString()).replaceAll(""));
            }
            for(Constructor ctor: constructors) {
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
        } else {
            for (Method m: methods) {
                if(m.toString().contains(word)) {
                    System.out.println(p.matcher(m.toString()).replaceAll(""));
                }
            }
            for(Constructor ctor: constructors) {

                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));

            }
        }

    }
}
