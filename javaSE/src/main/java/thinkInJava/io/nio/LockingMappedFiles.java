package thinkInJava.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by alex on 21.06.2016.
 */
public class LockingMappedFiles {
    static FileChannel fc;
    static final int LENTH= 0x8FFFFFF;

    public static void main(String[] args) throws IOException {
        fc=new RandomAccessFile("test.dat", "rw").getChannel();
        MappedByteBuffer out=
                fc.map(FileChannel.MapMode.READ_WRITE, 0 , LENTH);
        for (int i = 0; i < LENTH; i++) {
            out.put((byte)'x');

        }
        new LockAndModify(out, 0, 0 + LENTH/2);
        new LockAndModify(out, LENTH/3, LENTH/3 + LENTH/4);

    }
    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;
        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start=start;
            this.end=end;
            mbb.limit(end);
            mbb.position(start);
            buff=mbb.slice();
            start();
        }
        public void run() {
            try {
                FileLock fl=fc.tryLock(start, end, true);
                System.out.println("Locked: " + start + " to " + end);
                while(buff.position() < buff.limit() -1) {
                    buff.put((byte)(buff.get() +1));
                }
                fl.release();
                System.out.println("Released: "+start+" to "+ end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
