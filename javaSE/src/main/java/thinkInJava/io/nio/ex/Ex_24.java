package thinkInJava.io.nio.ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by alex on 16.06.2016.
 */
public class Ex_24 {
    public static void main(String[] args) throws FileNotFoundException {
        FileChannel fc=new FileOutputStream("data.txt").getChannel();
        ByteBuffer bb=ByteBuffer.allocate(32);
        DoubleBuffer db=bb.asDoubleBuffer();
        db.put(new double[]{25, 25, 3, 55});
        db.rewind();
        while (db.hasRemaining()) {
            System.out.println(db.get());
        }
    }
}
