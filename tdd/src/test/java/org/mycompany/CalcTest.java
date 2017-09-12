package org.mycompany;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by alex.ramanovich on 30.08.2017.
 */
public class CalcTest {
    Calc calc = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        calc = new Calc();
    }

    @Test
    public void whenAddThenSum() {
        int actualSum = calc.add(3, 2);
        assertEquals(5, actualSum);
    }

    @Test
    public void whenDivideAndDivisorZeroThenIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        calc.divide(3, 0);
    }

    @Test
    public void whenDivideThenQuotient() {
        double result = calc.divide(3, 1);
        assertEquals(3.0, result);
        result = calc.divide(5, 2);
        assertEquals(2.5, result);
        result = calc.divide(3, 7);
        assertEquals(3*1.0/7, result);
    }
}

