package thinkInJava.enumaration.ex;

import java.util.Random;

/**
 * Created by alex on 28.06.2016.
 */
public class Ex_2 {

    public static void main(String[] args) {
           CartoonCharacter.next();
    }


    enum CartoonCharacter {
        SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
        private static Random rand = new Random(47);
        public  static CartoonCharacter next() {
            return values()[rand.nextInt(values().length)];
        }
    }
}

