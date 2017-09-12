package thinkInJava.io.old_io.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import thinkInJava.io.old_io.BufferedInputFile;

/**
 * Created by ALEX on 07.05.2016.
 */
public class Ex_7 {
	public static List<String> read(String filename) {
		LinkedList<String> list=new LinkedList<>();
		try {

			BufferedReader in=new BufferedReader(new FileReader(filename));
			try {
				String s;
				while ((s=in.readLine())!=null) {
					list.add(s);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		List<String> list=read(BufferedInputFile.PATH);

		System.out.println(list);
		for(ListIterator<String> it=list.listIterator(list.size()); it.hasPrevious();) {
			System.out.println(it.previous());
		}
	}
}
