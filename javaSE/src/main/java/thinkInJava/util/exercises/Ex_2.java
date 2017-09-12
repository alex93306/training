package thinkInJava.util.exercises;

import java.util.*;

/**
 * Created by ALEX on 08.02.16.
 */
public class Ex_2 {
    public static void main(String[] args) {

        Integer[] aa =new Integer[100000];
        for(int i=0; i<aa.length; i++) {
            aa[i]=i;
        }
        List l=Arrays.asList(aa);
        ArrayList<Integer> a=new ArrayList<Integer>(l);
        ArrayList<Integer> b=new ArrayList<Integer>(l);
        final long start=System.currentTimeMillis();
        merge3(a, b);
        final long finish=System.currentTimeMillis();
        System.out.println("time:  " + (finish-start));
/*        SortedSet<String> c=new TreeSet<String>(Countries.names());
        String b=null;
        for(String s: c) {
            if(s.startsWith("B")) {
                b=s;
                break;
            }
        }
        Set<String> aSet=c.headSet(b);

        System.out.println(aSet);*/

    }

    static void merge(ArrayList a, ArrayList b) {
        int index=1;
        for(Object o: b) {
            a.add(index, o);
            index+=2;
        }
    }
    static void merge2(ArrayList a, ArrayList b) {
        List l=new LinkedList(a);
        int index=1;
        for(Object o: b) {
            l.add(index, o);
            index+=2;
        }
        a.clear();
        a.addAll(l);
    }
    static void merge3(ArrayList a, ArrayList b) {
        List l=new LinkedList();
        for(int i=0; i<a.size(); i++) {
                l.add(a.get(i));
            l.add(b.get(i));
        }
        a.clear();
        a.addAll(l);
    }

}

