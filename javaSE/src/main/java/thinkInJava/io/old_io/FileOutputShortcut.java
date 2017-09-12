package thinkInJava.io.old_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by ALEX on 07.05.2016.
 */
public class FileOutputShortcut {
	public static final String file = "C:/FileOutputShortcut.out";

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(
						new StringReader(BufferedInputFile.read(BufferedInputFile.PATH)));
		PrintWriter out=new PrintWriter(file);
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null) {
			out.println(lineCount++ + ": " + s);

		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
