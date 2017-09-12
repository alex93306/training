package thinkInJava.io.old_io.exercises;

import java.util.HashMap;
import java.util.Map;
import thinkInJava.io.old_io.BinaryFile;

/**
 * Created by ALEX on 10.05.2016.
 */
public class Ex_19 {
	public static void main(String[] args) {
		Map<Byte, Integer> map=new HashMap<>();
		byte[] bytes= BinaryFile.read("C:/test.txt");
		for(byte b: bytes) {
			Integer freq=map.get(b);
			map.put(b, freq == null ? 1 : freq + 1 );

		}
		System.out.println(map);
	}
}
