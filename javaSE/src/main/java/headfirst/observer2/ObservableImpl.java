package headfirst.observer2;

import java.util.Observable;

/**
 * Created by ALEX on 27.07.2017.
 */
public class ObservableImpl extends Observable {
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
}
