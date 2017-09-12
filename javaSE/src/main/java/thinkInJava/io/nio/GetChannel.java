package thinkInJava.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by alex on 11.05.2016.
 */
public class GetChannel {
    public static final int BSIZE = 1024;
    public static final String FILE = "C:/data.txt";

    public static void main(String[] args) throws IOException {
        FileChannel fc=new FileOutputStream(FILE).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc=new RandomAccessFile(FILE, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc=new FileInputStream(FILE).getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()) {
            System.out.println((char)buff.get());
        }
    }
}
