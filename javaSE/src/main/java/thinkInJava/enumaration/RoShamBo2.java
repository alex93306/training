package thinkInJava.enumaration;
import static thinkInJava.enumaration.Outcome.*;
/**
 * Created by alex on 08.07.2016.
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, LOSE)
    ;

    private Outcome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(Outcome paper,Outcome scissors,Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }
    @Override
    public Outcome compete(RoShamBo2 it) {
        switch(it) {
            default:
                case PAPER: return vPAPER;
                case SCISSORS: return vSCISSORS;
                case ROCK: return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(
                a + " vs. " + b + ": " + a.compete(b));
    }
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> clazz, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(clazz), Enums.random(clazz));
        }
    }
}
interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}