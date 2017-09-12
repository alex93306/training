package thinkInJava.io.serialization;

import java.io.*;

/**
 * Created by alex on 23.06.2016.
 */
public class Ex_27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C://out.dat")));
        out.writeObject(new A());
        out.close();
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("C://out.dat"));
        A a= (A) in.readObject();
        System.out.println(a.getB().getName());
        System.out.println(a);
    }
}
class A implements Serializable {
    private int n=34;
    private String name = "alex";
    private B b=new B();

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
class B implements Serializable {
    private String name = "Bob";

    public String getName() {
        return name;
    }
}