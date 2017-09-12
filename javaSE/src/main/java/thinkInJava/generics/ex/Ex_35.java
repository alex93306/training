package thinkInJava.generics.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ALEX on 03.08.2016.
 */
public class Ex_35 {
    public static void main(String[] args) {
        List<String> list= Collections.checkedList(new ArrayList<String>(Arrays.asList("dksfj")), String.class);
        set(list);
        String s1 =list.get(0);
    }
    @SuppressWarnings("unchecked")
    public static void set(List list) {
        list.add(new Cat());
    }
}

class Pet {

}
class Cat extends Pet{}
class Dog extends Pet{}