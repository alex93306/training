package thinkInJava.io.old_io.exercises;

import java.util.Map;
import java.util.TreeMap;
import thinkInJava.io.old_io.TextFile;

/**
 * Created by ALEX on 09.05.2016.
 */
public class Ex_17 {
	public static void main(String[] args) {

		System.out.println(count());

	}
	public static Map<Character, Integer> count() {
		Map<Character, Integer> map=new TreeMap<>();
		TextFile tf=new TextFile("C:/test.txt", "\\W+");
		for(String word: tf) {
			for (int i = 0; i < word.length(); i++) {
				Character c=word.charAt(i);
				Integer num=map.get(c);
				map.put(c, num == null ? 1 : num + 1);
				/*if(num == null) {
					map.put(c, 1);
				} else {
					map.put(c, num+1);
				}*/
			}

		}
		return map;
	}

}
