package thinkInJava.io.old_io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ALEX on 09.05.2016.
 */
public class BinaryFile {
	public static byte[] read(File bFile) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));
			try {
				byte[] data =new byte[in.available()];
				in.read(data);
				return data;
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	public static byte[] read(String bFile) {
		return read(new File(bFile));
	}
}
