package thinkInJava.io.old_io.exercises;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ALEX on 10.05.2016.
 */
public class Ex_21 {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=in.readLine()) != null && s.length() != 0) {
			System.out.println(s.toUpperCase());
		}
	}
}
