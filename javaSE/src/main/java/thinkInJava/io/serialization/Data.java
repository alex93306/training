package thinkInJava.io.serialization;

import java.io.Serializable;

/**
 * Created by alex on 22.06.2016.
 */
public class Data implements Serializable {
    private int n;
    public Data(int n) {
        this.n=n;

    }
    public String toString() {
        return Integer.toString(n);
    }
}

