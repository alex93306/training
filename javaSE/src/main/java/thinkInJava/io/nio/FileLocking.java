package thinkInJava.io.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 21.06.2016.
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos=new FileOutputStream("C://file.txt", true);
        FileLock f1=fos.getChannel().tryLock(0, 20, false);
        if(f1 != null) {
            System.out.println("Locked file");
            TimeUnit.SECONDS.sleep(100);
            f1.release();
            System.out.println("Released lock");
        }

    }
}
