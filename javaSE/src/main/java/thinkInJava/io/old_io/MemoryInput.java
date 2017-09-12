package thinkInJava.io.old_io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ALEX on 06.05.2016.
 */
public class MemoryInput {
	public static void main(String[] args) {
		StringReader in=null;
		try {
			try {
				in=new StringReader(BufferedInputFile.read("C:/test.txt"));
				int c;
				while ((c = in.read()) != -1) {
					System.out.println((char)c);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
