package thinkInJava.exceptions;

/**
 * Created by alex on 04.12.2015.
 */
public class Ex_22 {
    public static void main(String[] args) {
        try {
            FailingConstructor f = new FailingConstructor(true);
            try {

            } finally {
                    f.dispose();
            }

        } catch (BaseBallException e) {
            e.printStackTrace();
        }
    }
}

class FailingConstructor {
    WithDispose withDispose, wd2;

    FailingConstructor(boolean fail) throws BaseBallException {
        withDispose = new WithDispose();
        try {
            if (fail) throw new BaseBallException();
        } catch (BaseBallException e) {
            withDispose.dispose();
            throw e;
        }
        wd2 = new WithDispose();
    }
    void dispose() {
        wd2.dispose();
        withDispose.dispose();
    }


}

class WithDispose {
    void dispose() {
        System.out.println("clean up");
    }
}