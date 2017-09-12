import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by alex.ramanovich on 25.08.2017.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(cal());
        System.out.println(cal(3, 6));

        Optional<Double> opt = cal(34,44);
        if(opt.isPresent())
            System.out.println(opt.get());
        opt.ifPresent(System.out::println);
    }

    private static Optional<Double> cal(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for(int i: scores)
            sum += i;
        return Optional.of((double)sum/scores.length);
    }

}
