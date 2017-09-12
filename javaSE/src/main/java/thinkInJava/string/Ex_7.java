package thinkInJava.string;

import java.util.regex.Pattern;

/**
 * Created by ALEX on 05.12.15.
 */
public class Ex_7 {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("\\p{javaUpperCase}.*\\.");
        System.out.println(p.matcher("И lll ..").matches());
    }
}
