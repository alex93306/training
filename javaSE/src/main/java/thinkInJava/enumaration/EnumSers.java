package thinkInJava.enumaration;

import java.util.EnumSet;
import static thinkInJava.enumaration.AlarmPoints.*;

/**
 * Created by alex on 24.06.2016.
 */
 enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN
} ///:~
public class EnumSers {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE2));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);

    }
}
