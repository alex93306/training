package thinkInJava.util.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import thinkInJava.generics.Generator;

/**
 * Created by ALEX on 01.05.2016.
 */
public class Ex_40 {
	public static void main(String[] args) {
		List<StringHolder> stringList=new ArrayList<StringHolder>();
		for (int i = 0; i < 10; i++) {
			stringList.add(StringHolder.generator().next());
		}
		System.out.println(stringList);
		Collections.sort(stringList);
		System.out.println(stringList);
		Collections.shuffle(stringList);
		StringHolder strZero=stringList.get(0);
		System.out.println("befor "  + stringList);
		Collections.sort(stringList, new CompareSecond());
		System.out.println("after " + stringList);
		System.out.println(Collections.binarySearch(stringList, strZero, new CompareSecond()));
	}
}
class CompareSecond implements Comparator<StringHolder> {
	public int compare(StringHolder o1, StringHolder o2) {
		return o1.second.compareTo(o2.second);
	}
}
class StringHolder implements Comparable<StringHolder> {
	String first;
	String second;

	public StringHolder(String first, String second) {
		this.first = first;
		this.second = second;
	}

	public int compareTo(StringHolder o) {
		return first.compareTo(o.first);
	}

	public static Generator<StringHolder> generator() {
		final String[] strings="one two three four six seven eight ten eleven twelve thirteen".split(" ");
		final Random random=new Random();
		return new Generator<StringHolder>() {
			public StringHolder next() {
				return new StringHolder(strings[random.nextInt(strings.length)], strings[random.nextInt(strings.length)]);
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
		return "StringHolder{" +
						"first='" + first + '\'' +
						", second='" + second + '\'' +
						'}';
	}
}