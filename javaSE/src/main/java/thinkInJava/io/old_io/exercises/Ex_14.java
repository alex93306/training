package thinkInJava.io.old_io.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ALEX on 09.05.2016.
 */
public class Ex_14 {
	static String file="C:/Ex_14.txt";
	static String file2="C:/Ex_14_2.txt";
	public static void main(String[] args) {

		List<String> list=Ex_7.read("C:/test.txt");

		long start2=System.currentTimeMillis();
		try {
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
			test(list, out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		long finishTime2=System.currentTimeMillis();
		System.out.println("buffered " + (finishTime2-start2));
		long startTime=System.currentTimeMillis();
		try {
			PrintWriter out2=new PrintWriter(file2);
			test(list, out2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		long finishTime=System.currentTimeMillis();
		System.out.println("Writing without buffering takes " + (finishTime-startTime));


		try {
			PrintWriter out2=new PrintWriter("C:/3.txt");
			test(list, out2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			PrintWriter out2=new PrintWriter("C:/4.txt");
			test(list, out2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			PrintWriter out2=new PrintWriter("C:/5.txt");
			test(list, out2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
				}
	public static void test(List<String> list, PrintWriter out) {
		try {
			long s1=System.currentTimeMillis();
			int lineCount = 1;
			for(String item: list) {
				out.println(item);
			}
			long s2=System.currentTimeMillis();
			System.out.println("Writing" + (s2-s1));
		} finally {
			out.close();
		}
	}
	}

