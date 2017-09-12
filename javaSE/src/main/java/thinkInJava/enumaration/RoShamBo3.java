package thinkInJava.enumaration;

import static thinkInJava.enumaration.Outcome.*;

/**
 * Created by alex on 08.07.2016.
 */
public enum  RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default: // To placate the compiler
                case PAPER: return DRAW;
                case SCISSORS: return LOSE;
                case ROCK: return WIN;
            }
        }
    },
    SCISSORS {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return WIN;
                case SCISSORS: return DRAW;
                case ROCK: return LOSE;
            }
        }
    },
    ROCK {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return LOSE;
                case SCISSORS: return WIN;
                case ROCK: return DRAW;
            }
        }
    };

    @Override
    public abstract Outcome compete(RoShamBo3 competitor);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
