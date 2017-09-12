package thinkInJava.io.old_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by ALEX on 08.05.2016.
 */
public class TextFile extends ArrayList<String> {
	public static String read(String filename) {
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader in=new BufferedReader(new FileReader(filename));
			try {
				String s;
				while((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	public static void write(String filename, String text) {
		try {
			PrintWriter out=new PrintWriter(filename);
			try {
				out.println(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public TextFile(String filename, String splitter) {
		super(Arrays.asList(read(filename).split(splitter)));
		// Regular expression split() often leaves an empty
		// String at the first position:
		if(get(0).equals("")) remove(0);

	}

	public TextFile(String filename) {
		this(filename, "\n");
	}

	public void write(String filename) {
		try {
			PrintWriter out=new PrintWriter(filename);
			try {
				for(String item: this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (FileNotFoundException e) {
			new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String fileText=read("C:/test.txt");
		write("C:/new.txt", fileText);
		TextFile text=new TextFile("C:/new.txt");
		text.write("C:/new2.txt");
		TreeSet<String> words=new TreeSet<>(new TextFile("C:/new2.txt", "\\W+"));
		System.out.println(words.headSet("a"));
	}

}
