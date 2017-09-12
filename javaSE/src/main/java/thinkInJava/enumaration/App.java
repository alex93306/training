package thinkInJava.enumaration;

import thinkInJava.generics.Generator;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by ALEX on 23.06.2016.
 */
public class App {

}

enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            System.out.println(a);
            return DateFormat.getDateInstance().format(new Date());

        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    int a=3;
    abstract String getInfo();

    public static void main(String[] args) {
        for(ConstantSpecificMethod csm: values()) {
            System.out.println(csm.getInfo());
        }
    }
}
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);


    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}



class EnumImplement {
    public static <T> void printNext(Generator<T> arg) {
        System.out.println(arg.next() + ", ");
    }
    public static void main(String[] args) {
        CartoonCharacter cc=CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
enum Search {HITHER, YON}
class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e=Search.HITHER;
        for(Enum en: e.getClass().getEnumConstants()) {
            System.out.println(en);
        }

    }
}

class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            case RED: color=Signal.GREEN;
                break;
            case GREEN: color =Signal.YELLOW;
                break;
            case YELLOW: color=Signal.RED;
                break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }
    public static void main(String[] args) {
        TrafficLight t=new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }


    }
}

enum Signal {
    GREEN, YELLOW, RED;
}


enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    public String toString() {
        String name = name();
        String lower = name.substring(1).toLowerCase();
        return name.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }

}
