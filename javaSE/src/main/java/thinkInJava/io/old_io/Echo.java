package thinkInJava.io.old_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ALEX on 09.05.2016.
 */
public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = stdin.readLine()) != null && s.length()!= 0)
			System.out.println(s);
		// An empty line or Ctrl-Z terminates the program
	}
}
