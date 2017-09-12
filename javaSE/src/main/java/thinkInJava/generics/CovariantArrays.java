package thinkInJava.generics;

/**
 * Created by ALEX on 19.07.2016.
 */


class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit=new Apple[10];
        fruit[0]=new Apple();
        fruit[1]=new Jonathan();
        try {
            fruit[0]=new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fruit[0]=new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
