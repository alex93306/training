package thinkInJava.io.serialization;

import java.io.*;

/**
 * Created by alex on 23.06.2016.
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C://out.dat")));
        out.writeObject(new C());
        out.close();
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("C://out.dat"));
        C c= (C) in.readObject();
        System.out.println(c);
    }
}
class C implements Serializable {
    private int n=34;
    private String name = "alex";
    private transient B b=new B();

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public B getB() {
        return b;
    }

    @Override
    public String toString() {
        return "A{" +
                "n=" + n +
                ", name='" + name + '\'' +
                ", b=" + b +
                '}';
    }
}