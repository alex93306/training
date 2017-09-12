package headfirst.strategy2;

/**
 * Created by ALEX on 27.07.2017.
 */
public class App {
    public static void main(String[] args) {
        User user = new User();
        user.setCalculator(new CalculatorV1());
    }
}
