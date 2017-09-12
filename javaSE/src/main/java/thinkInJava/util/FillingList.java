package thinkInJava.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ALEX on 05.02.16.
 */
public class FillingList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>(Collections.nCopies(4, "haha"));
        System.out.println(list);
        Collections.fill(list, "tadam");
        System.out.println(list);
    }
}
