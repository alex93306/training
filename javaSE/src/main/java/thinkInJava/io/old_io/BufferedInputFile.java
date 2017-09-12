package thinkInJava.io.old_io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.beans.binding.StringBinding;

/**
 * Created by ALEX on 06.05.2016.
 */
public class BufferedInputFile {
	public static final String PATH = "C:/test.txt";
	public static String read(String filename) throws IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(new FileInputStream(filename), "windows-1251"));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s = in.readLine()) != null) {
			sb.append(s);
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(read("C:/test.txt"));
	}
}
