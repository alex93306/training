package headfirst.strategy2;

/**
 * Created by ALEX on 27.07.2017.
 */
public class User {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void print() {
//        System.out.println(calculator.calc());
    }
}
