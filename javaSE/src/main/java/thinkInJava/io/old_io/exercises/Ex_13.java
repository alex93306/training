package thinkInJava.io.old_io.exercises;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import thinkInJava.io.old_io.FilesPath;

/**
 * Created by ALEX on 08.05.2016.
 */
public class Ex_13 {
	public static void main(String[] args) throws IOException {
		LineNumberReader in=new LineNumberReader(new FileReader(FilesPath.INPUT_FILE));
		PrintWriter out =new PrintWriter(FilesPath.OUTPUT_FILE);
		String s;
		while((s=in.readLine()) != null) {
			out.println(in.getLineNumber() + ": " + s);
		}
		out.close();

	}
}
