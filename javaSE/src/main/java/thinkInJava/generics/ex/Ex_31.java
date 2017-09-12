package thinkInJava.generics.ex;

/**
 * Created by ALEX on 31.07.2016.
 */
public class Ex_31 {
    private int i;
    public static void main(String[] args) {
        System.out.println(new Ex_31().i);
    }
}
interface Inteface<T> {

}
class Employee implements Inteface<String> {

}
class Manager extends Employee implements Inteface<String> {

}
