package thinkInJava.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by alex on 07.06.2016.
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb=ByteBuffer.allocate(BSIZE);
        int i=0;
        while(i++ < bb.limit()) {
            if(bb.get() != 0) {
                System.out.print("nonzero");
            }
        }
        System.out.print("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) !=0) {
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();

        bb.asShortBuffer().put((short)2550);
        System.out.println(bb.getShort());

    }
}
