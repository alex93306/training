package thinkInJava.io.old_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ALEX on 08.05.2016.
 */
public class StoringAndRecoveringData {
	public static void main(String[] args) throws IOException {
		DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Data.txt")));
		out.writeUTF("f");
		/*out.writeDouble(3.14);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.writeUTF("Square root of 2");*/
		out.close();
		DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Data.txt")));
	/*	System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());*/
		System.out.println(in.readUTF());
		in.close();
	}
}
