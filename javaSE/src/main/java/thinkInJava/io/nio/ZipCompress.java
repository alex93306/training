package thinkInJava.io.nio;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by alex on 21.06.2016.
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream f=new FileOutputStream("C:\\test.zip");
        CheckedOutputStream csum=new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos=new ZipOutputStream(csum);
        BufferedOutputStream out=new BufferedOutputStream(zos);
        zos.setComment("A test of Java zipping");

        for(String arg: new String[]{"C:\\1.txt", "C:\\2.txt"}) {
            System.out.println("Writing fiel" + arg);
            BufferedReader in=
                    new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c=in.read()) != -1) {
                System.out.println("writing " + c);
                out.write(c);
            }
            /*for (int i = 0; i < 10; i++) {
                out.write(i);
            };*/
            in.close();
            out.flush();
        }
        out.close();

        System.out.println("Checksum: " + csum.getChecksum().getValue());
        System.out.println("Reading file");

        FileInputStream fi=new FileInputStream("C:\\test.zip");
        CheckedInputStream cis=new CheckedInputStream(fi, new Adler32());
        ZipInputStream zis=new ZipInputStream(cis);
        BufferedInputStream bis=new BufferedInputStream(zis);
        ZipEntry ze;
        while((ze = zis.getNextEntry()) != null) {
            System.out.println("Reading file" + ze);
            int x;
            while((x = bis.read()) != -1) {
                System.out.print(x + " ");
            }
        }
        System.out.println("Checksum: " + cis.getChecksum().getValue());
        bis.close();

        ZipFile zf=new ZipFile("C:\\test.zip");
        Enumeration e=zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2= (ZipEntry) e.nextElement();
        }
    }
}
