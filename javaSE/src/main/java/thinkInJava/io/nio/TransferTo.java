package thinkInJava.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by alex on 13.05.2016.
 */
public class TransferTo {
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream("C:/data.txt").getChannel();
        FileChannel out = new FileOutputStream("C:/data2.txt").getChannel();
        in.transferTo(0, in.size(), out);

    }
}
