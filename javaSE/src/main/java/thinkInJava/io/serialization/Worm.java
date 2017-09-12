package thinkInJava.io.serialization;

import java.io.*;
import java.util.Random;

/**
 * Created by alex on 22.06.2016.
 */
public class Worm implements Serializable {
    private static Random random=new Random(47);
    private Data[] d={new Data(random.nextInt(10)), new Data(random.nextInt(10))};
    private Worm next;
    private char c;
    public Worm(int i, char c) {
        System.out.println("Worm constructor: " + i);
        this.c=c;
        if(--i > 0) {
            next = new Worm(i, (char) (c+1));
        }
    }
    public Worm() {
        System.out.println("Default constructor");
    }
    public String toString() {
        StringBuilder sb=new StringBuilder(":");
        sb.append(c);
        sb.append("(");
        for(Data dat: d) {
            sb.append(dat + ", ");
        }
        sb.append(")");
        if(next != null) {
            sb.append(next);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w=new Worm(6, 'a');
        System.out.print("w = " + w);
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C://out.dat"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("C://out.dat"));
        String s= (String) in.readObject();
        Worm w2= (Worm) in.readObject();
        System.out.print(s + "w2=" + w2);
        in.close();
        ByteArrayOutputStream bout=new ByteArrayOutputStream();
        ObjectOutputStream out2=new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2=new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3= (Worm) in2.readObject();
        System.out.println(s + "w3 = " + w3);


//
    }
}
