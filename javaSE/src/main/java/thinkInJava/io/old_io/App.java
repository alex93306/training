package thinkInJava.io.old_io;

import thinkInJava.enumaration.Enums;

import java.io.*;

/**
 * Created by ALEX on 04.05.2016.
 */
public class App {
	public static final String PATH = "C:/test.txt";
	public static void main(String[] args) throws IOException {

    }
}
enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCource.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
    interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP
        }
        enum MainCource implements Food {
            BURRITO, HUMMOUS
        }
    }
}

