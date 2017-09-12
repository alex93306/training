package thinkInJava.io.old_io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by alex on 03.05.2016.
 */
public class Dirlist {

    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args) {
        File path=new File("./javaSE/src/main/java/org/mycompany/util");
        String[] list=null;

            list=path.list(new FilenameFilter() {
                private Pattern pattern=Pattern.compile("^[A-C].*\\.java");
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list) {
            System.out.println(dirItem);
        }

    }
}
class DirFilter implements FilenameFilter {
    private Pattern pattern;
    DirFilter(String regex) {
        pattern=Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}


