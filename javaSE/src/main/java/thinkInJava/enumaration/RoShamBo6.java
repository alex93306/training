package thinkInJava.enumaration;

import static thinkInJava.enumaration.Outcome.*;

/**
 * Created by alex on 08.07.2016.
 */
public enum  RoShamBo6 implements Competitor<RoShamBo6>{
    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table=
            {
                    { DRAW, LOSE, WIN }, // PAPER
                    { WIN, DRAW, LOSE }, // SCISSORS
                    { LOSE, WIN, DRAW }, // ROCK
            };

    @Override
    public Outcome compete(RoShamBo6 competitor) {
        return table[this.ordinal()][competitor.ordinal()];
    }
}
