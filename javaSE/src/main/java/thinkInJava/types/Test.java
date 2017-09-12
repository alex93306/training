package thinkInJava.types;

/**
 * Created by ALEX on 10.07.2016.
 */
public class Test {
    public static void main(String[] args) {
        char[] cc={'a', 'b'};
        Class c=Integer.TYPE;
        System.out.println(c.getName() + "\n" + c.getSimpleName() + "\n" + c.getCanonicalName());
        System.out.println(c.getSuperclass().getName() + "\n" + c.getSuperclass().getSimpleName());
    }
}
