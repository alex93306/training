package thinkInJava.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by alex on 13.05.2016.
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    private static final String file = "C:/test.txt";

    public static void main(String[] args) throws IOException {
        FileChannel fc =
                new FileOutputStream("C:/test.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc=new FileInputStream("C:/test.txt").getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        buff.rewind();
        String encoding=System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " +
                Charset.forName(encoding).decode(buff));
        fc.close();
        fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("Some tesxt".getBytes("UTF-16BE")));
        fc.close();

        fc=new FileInputStream(file).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        fc.close();

        fc=new FileOutputStream(file).getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some texxxxx");
        fc.write(buff);
        fc.close();

        fc=new FileInputStream(file).getChannel();
        buff.clear();

        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());


    }
}
