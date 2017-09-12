package thinkInJava.generics.ex;

import thinkInJava.enumaration.Input;
import thinkInJava.generics.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alex on 11.07.2016.
 */
public class Ex_13 {
    public static <T> Collection<T> fill(Collection<T> coll,
                                         Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Input> cc=fill(new ArrayList<Input>(), new Generator<Input>() {
            @Override
            public Input next() {
                return null;
            };
        }, 5 );
        
    }
}
