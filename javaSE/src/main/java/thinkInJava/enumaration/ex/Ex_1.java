package thinkInJava.enumaration.ex;

import static thinkInJava.enumaration.ex.Signal.GREEN;
import static thinkInJava.enumaration.ex.Signal.RED;
import static thinkInJava.enumaration.ex.Signal.YELLOW;

/**
 * Created by alex on 28.06.2016.
 */
public class Ex_1 {
    public static void main(String[] args) {
        TrafficLight t=new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
enum Signal { GREEN, YELLOW, RED, }
class TrafficLight {
    Signal color= RED;
    public void change() {
        switch (color) {
            case RED: color=GREEN;
                break;
            case GREEN: color = YELLOW;
                break;
            case YELLOW: color = RED;
                break;
            default:
                System.out.println("hello");
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }
}
