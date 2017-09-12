package thinkInJava.enumaration;

import thinkInJava.generics.Generator;

import java.util.EnumMap;
import java.util.Random;
import static thinkInJava.enumaration.Input.*;

/**
 * Created by alex on 06.07.2016.
 */

class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration {TRANSIENT}
    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                        break;
                }
            }
        },
        ADDING_MONEY {

            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        System.out.println("added " + input.amount());
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                        break;

                }
            }

        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                    System.out.println("here is your " + selection);
                    amount -= selection.amount();
                    state = GIVING_CHANGE;
                }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount>0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL { void output() {
            System.out.println("Halted"); } };
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) {
            isTransient=true;
        }
        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }
        void output() {
            System.out.println(amount);
        }
    }

static void run(Generator<Input> gen) {
    while (state != State.TERMINAL) {
        state.next(gen.next());
        while (state.isTransient) {
            state.next();
        }
        state.output();
    }
}

    public static void main(String[] args) {
        run(new RandomInputGenerator());
    }

}
class RandomInputGenerator implements Generator<Input> {

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;
    private Category(Input... values) {
        this.values = values;
    }

    private static EnumMap<Input, Category> categories =
            new EnumMap<Input, Category>(Input.class);
    static {
        for (Category c: values()) {
            for(Input i: c.values) {
                categories.put(i, c);
            }
        }
    }
    public static Category categorize(Input input) {
        return categories.get(input);
    }

}
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;
    Input(int value) {
        this.value = value;
    }
    Input(){}

    int amount() {
        return value;
    }
    static Random random = new Random(47);
    public static Input randomSelection() {
        return values()[random.nextInt(values().length)];
    }
}
