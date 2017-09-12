package headfirst.observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ALEX on 27.07.2017.
 */
public class Observer2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update2");
    }
}
