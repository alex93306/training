package thinkInJava.exceptions;

/**
 * Created by alex on 03.12.2015.
 */

class BaseBallException extends Exception {

}
class Foul extends BaseBallException {}
class Strike extends BaseBallException {}

abstract class Inning {
    public Inning() throws BaseBallException{}
    public void event() throws BaseBallException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk(){}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws BaseBallException;
    public void rainHard() throws RainedOut;
}


public class StormyInning extends Inning implements Storm {



    public StormyInning() throws BaseBallException, RainedOut{
    }

    public void event() {}

    @Override
    public void atBat() throws PopFoul {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            Inning i=new StormyInning();
        } catch (BaseBallException e) {
            e.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        }
    }
}
