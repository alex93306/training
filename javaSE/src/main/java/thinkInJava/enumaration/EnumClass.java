package thinkInJava.enumaration;

/**
 * Created by ALEX on 22.06.2016.
 */
enum Shrubbery { GROUND, CRAWLING, HANGING }
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s: Shrubbery.values()) {
            System.out.println(s + " ordinal:" + s.ordinal() );
            System.out.println(s.compareTo(Shrubbery.GROUND));
            System.out.println(s.equals(Shrubbery.GROUND));
            System.out.println(s == Shrubbery.GROUND);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.getClass());
            System.out.println(s.name());
            System.out.println(Shrubbery.GROUND.getClass());
            System.out.println("-----------------------------");
        }
    }
}
