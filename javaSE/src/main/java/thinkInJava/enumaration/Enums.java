package thinkInJava.enumaration;

import java.util.Random;

/**
 * Created by alex on 24.06.2016.
 */
public class Enums {
    private static Random rand=new Random(47);
    public static <T extends Enum<T>> T random(Class<T> clazz) {
        return random(clazz.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
