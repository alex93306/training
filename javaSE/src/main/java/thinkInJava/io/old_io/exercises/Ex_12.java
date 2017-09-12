package thinkInJava.io.old_io.exercises;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;
import thinkInJava.io.old_io.BufferedInputFile;
import thinkInJava.io.old_io.FileOutputShortcut;

/**
 * Created by ALEX on 08.05.2016.
 */
public class Ex_12 {
	public static void main(String[] args) throws FileNotFoundException {
		List<String> list;
		if(args.length == 1) {
			list=Ex_7.read(args[0]);
		} else {
			list=Ex_7.read(BufferedInputFile.PATH);
		}
		PrintWriter out=new PrintWriter(FileOutputShortcut.file);
		int lineCounter=list.size();
		for(ListIterator<String> lit = list.listIterator(list.size()); lit.hasPrevious();){
			out.println(lineCounter-- + " " +lit.previous());
		}
		out.close();
	}
}
