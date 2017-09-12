package thinkInJava.io;

import java.io.*;

/**
 * Created by alex on 04.05.2016.
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream out=new ByteArrayOutputStream();
        ObjectOutputStream out2=new ObjectOutputStream(out);
        out2.writeObject(new E());
        E e= (E) new ObjectInputStream(new ByteArrayInputStream(out.toByteArray())).readObject();
        System.out.println(e.a);

    }
}
class D {
    static int c=34;
    void f() {
        System.out.println("base f");
    }
}
class Dex  extends D{
    void f() {
        System.out.println("derived f" + c);
    }
    String s(int i) {
        switch (i) {
            default:
            case 5:
            case 0: return "0";
            case 1: return "1";
            case 2: return "2";
        }
    }
}
class E implements Serializable{
  public static final int a=5;

        }
class Window implements Serializable {
    Window(int i) {
        System.out.println("call window " + i);
    }
}

class A implements Externalizable {
    private int a;
    private Window w1=new Window(1);

    public A() {

    }
    public A(int a) {
        this.a=a;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

           out.writeInt(a);
        out.writeObject(w1);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readInt();
        in.readObject();
    }
}
