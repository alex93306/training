package headfirst.observer2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

/**
 * Created by ALEX on 27.07.2017.
 */
public class App {
    public static void main(String[] args) {
        Observable observable = new ObservableImpl();
        observable.addObserver(new Observer1());
        observable.addObserver(new Observer2());
        observable.notifyObservers();
//        InputStream in = new BufferedInputStream(new FileInputStream())
    }
}
abstract  class B {
    void m() {
       int b = new C().a;
    }

   class C {
       private int a= 34;
       {
           Calendar calendar = new GregorianCalendar();
       }
   }
}