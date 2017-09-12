package thinkInJava.io.old_io;

import java.io.PrintWriter;

/**
 * Created by ALEX on 09.05.2016.
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello, world!");
	}
}
