package thinkInJava.annotations;

/**
 * Created by alex on 06.07.2016.
 */
public class Testable {
    public void execute() {
        System.out.println("Executing");
    }

    @Test void testExecute() {
        execute();
    }
}
