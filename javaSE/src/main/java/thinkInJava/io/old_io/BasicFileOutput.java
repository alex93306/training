package thinkInJava.io.old_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ALEX on 06.05.2016.
 */
public class BasicFileOutput {
	static String file="C:/BasicFileOutput.out";
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(
						new FileReader("C:/test.txt")
		);
		PrintWriter out = new PrintWriter(
						new BufferedWriter(new FileWriter(file))
		);
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount ++ + ": " +s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
