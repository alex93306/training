package thinkInJava.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by alex on 12.05.2016.
 */
public class ChannelCopy {
    private static final int BSIZE = 10;

    public static void main(String[] args) throws IOException {
        FileChannel in=new FileInputStream(GetChannel.FILE).getChannel(),
                out=new FileOutputStream("C:/data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while(in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

    }
}
