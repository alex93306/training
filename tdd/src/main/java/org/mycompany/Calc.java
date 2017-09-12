package org.mycompany;

/**
 * Created by alex.ramanovich on 30.08.2017.
 */
public class Calc {

    public int add(int first, int second) {
        return first + second;
    }

    public double divide(int divident, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Divisor equals 0");
        return divident * 1.0 /divisor;
    }
}
