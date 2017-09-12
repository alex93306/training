package thinkInJava.io.old_io.exercises;

import java.util.List;
import java.util.ListIterator;
import thinkInJava.io.old_io.BufferedInputFile;

/**
 * Created by ALEX on 08.05.2016.
 */
public class Ex_9 {
	public static void main(String[] args) {
		List<String> list;
		if(args.length == 1) {
			list=Ex_7.read(args[0]);
		} else {
			list=Ex_7.read(BufferedInputFile.PATH);
		}
		for(ListIterator<String> it=list.listIterator(list.size()); it.hasPrevious();) {
			String upperS=it.previous().toUpperCase();
			System.out.println(upperS);
		}
	}
}
