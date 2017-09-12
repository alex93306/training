package thinkInJava.enumaration;

/**
 * Created by alex on 24.06.2016.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
             for (Course c: Course.values()) {
                 Food food=c.randomSelection();
                 System.out.println(food);
             }
            System.out.println("-----");
        }

    }
}
