package thinkInJava.io.old_io.exercises;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ALEX on 06.05.2016.
 */
public class Ex_2 {

}
class SortedDirList {
	private File path;
	public SortedDirList(File file) {
		this.path=file;
	}
	public List<File> list() {
		File[] s=path.listFiles();
		Arrays.sort(s);
		return Arrays.asList(s);
	}
	public List<File> list(final String regex) {
		File[] s=path.listFiles(new FilenameFilter() {
			@Override public boolean accept(File dir, String name) {
				Pattern pattern=Pattern.compile(regex);
				Matcher m=pattern.matcher(name);
				return m.matches();
			}
		});
		Arrays.sort(s);
		return new ArrayList<>(Arrays.asList(s));
	}


}
