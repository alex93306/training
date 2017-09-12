package thinkInJava.enumaration;

import java.util.EnumMap;

/**
 * Created by alex on 28.06.2016.
 */
interface Command { void action(); }
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> enumMap = new
                EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        enumMap.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("dskfjsdfj");
            }
        });
    }
}
