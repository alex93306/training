package thinkInJava.io.old_io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by ALEX on 06.05.2016.
 */
public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(
						new ByteArrayInputStream(
										BufferedInputFile.read("C:/test.txt").getBytes()
						)
		);

		while (in.available() != 0) {
			System.out.println((char)in.readByte());
		}

	}
}
