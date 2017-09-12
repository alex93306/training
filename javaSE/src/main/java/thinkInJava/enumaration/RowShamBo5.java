package thinkInJava.enumaration;

import java.util.EnumMap;

import static thinkInJava.enumaration.Outcome.*;

/**
 * Created by alex on 08.07.2016.
 */
public enum RowShamBo5 implements Competitor<RowShamBo5> {

    PAPER, SCISSORS, ROCK
    ;

    static EnumMap<RowShamBo5, EnumMap<RowShamBo5, Outcome>>
            table=new EnumMap<RowShamBo5, EnumMap<RowShamBo5, Outcome>>(RowShamBo5.class);
    static {
        for (RowShamBo5 it: RowShamBo5.values()) {
            table.put(it, new EnumMap<RowShamBo5, Outcome>(RowShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }
    static void initRow(RowShamBo5 it,
                        Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RowShamBo5, Outcome> row=new EnumMap<RowShamBo5, Outcome>(RowShamBo5.class);
        row.put(RowShamBo5.PAPER, vPAPER);
        row.put(RowShamBo5.SCISSORS, vSCISSORS);
        row.put(RowShamBo5.ROCK, vROCK);
    }

    @Override
    public Outcome compete(RowShamBo5 competitor) {
        return table.get(this).get(competitor);
    }
}
