package thinkInJava.util.exercises;

import java.util.*;

/**
 * Created by ALEX on 10.02.16.
 */
public class Ex_7 {
    public static void main(String[] args) {
        /*List<String> l1=new ArrayList<String>(Countries.names());
        List<String> l2=new LinkedList<String>(Countries.names());
        Iterator<String> i=l1.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        ListIterator<String> i2=l2.listIterator();
        int index=1;
        for(ListIterator<String> it=l1.listIterator(); it.hasNext(); ) {
           l1.add(index, it.next());
            index +=2;
        }

        int alindex=0;
        for(ListIterator<String> it=l1.listIterator(); it.hasPrevious();) {
            l1.add(alindex,it.previous();
            alindex+=2;
        }*/
       /*m(new TreeSet<A>(), A.class);*/
        new TreeSet<A>(Arrays.asList(new A()));
    }
    public static<T> Set<T> m(Set<T> set,Class<T> type ) {
        for(int i=0; i<10; i++) {
            try {
                set.add(
                        type.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }}

return set;
        }
    }


class A {

}