package thinkInJava.util.exercises;

import thinkInJava.generics.Generator;

import java.util.Random;

/**
 * Created by alex on 02.05.2016.
 */
public class Ex_42 {

}
class TwoStringAlphabetic implements Comparable<TwoStringAlphabetic> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoStringAlphabetic)) return false;

        TwoStringAlphabetic TwoStringAlphabetic = (TwoStringAlphabetic) o;

        if (first != null ? !first.equals(TwoStringAlphabetic.first) : TwoStringAlphabetic.first != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return first != null ? first.hashCode() : 0;
    }

    String first;
    String second;

    public TwoStringAlphabetic(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(TwoStringAlphabetic o) {
        return first.toLowerCase().compareTo(o.first.toLowerCase());
    }

    public static Generator<TwoStringAlphabetic> generator() {
        final String[] strings="one two three four six seven eight ten eleven twelve thirteen".split(" ");
        final Random random=new Random();
        return new Generator<TwoStringAlphabetic>() {
            public TwoStringAlphabetic next() {
                return new TwoStringAlphabetic(strings[random.nextInt(strings.length)], strings[random.nextInt(strings.length)]);
            }
        };
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override public String toString() {
        return "TwoStringAlphabetic{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}