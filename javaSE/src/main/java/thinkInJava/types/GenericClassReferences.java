package thinkInJava.types;

/**
 * Created by ALEX on 10.07.2016.
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass=int.class;
        Class<Integer> genericIntClass=Integer.class;
        genericIntClass=int.class;
        intClass = genericIntClass;

    }
}
