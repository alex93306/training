package thinkInJava.io.serialization;

import java.io.*;
import static thinkInJava.io.serialization.Printer.print;

/**
 * Created by alex on 23.06.2016.
 */
public class Ex_28 {
}

class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }

    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blips {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Blips.out"));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
// Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out"));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
// OOPS! Throws an exception:
print("Recovering b2:");
 b2 = (Blip2)in.readObject();
    }
}
class Printer {
    public static void print(String s) {
        System.out.println(s);
    }
}