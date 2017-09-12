package thinkInJava.util.exercises;

import thinkInJava.generics.Generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by alex on 02.05.2016.
 */
public class Ex_41 {
    public static void main(String[] args) {
        Set<TwoString> twoStrings=new HashSet<>();

    }
}
class TwoString implements Comparable<TwoString> {
    String first;
    String second;

    public TwoString(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(TwoString o) {
        return first.compareTo(o.first);
    }

    public static Generator<TwoString> generator() {
        final String[] strings="one two three four six seven eight ten eleven twelve thirteen".split(" ");
        final Random random=new Random();
        return new Generator<TwoString>() {
            public TwoString next() {
                return new TwoString(strings[random.nextInt(strings.length)], strings[random.nextInt(strings.length)]);
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
        return "TwoString{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}