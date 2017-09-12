package thinkInJava.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 06.07.2016.
 */
public class UseCaseTracker {
    public static  void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for(Method m: cl.getDeclaredMethods())   {
            UseCase uc=m.getAnnotation(UseCase.class);
            if(uc != null) {
                System.out.println("Found Use case: " + uc.id() +
                " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i: useCases) {
            System.out.println("Missing " + i);
        }
    }
    public static void main(String[] args) {
trackUseCases(new ArrayList<>(Arrays.asList(47, 48, 49, 50)), PasswordUtils.class);
    }
}
