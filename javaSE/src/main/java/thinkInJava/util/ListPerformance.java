package thinkInJava.util;

import java.util.*;

/**
 * Created by ALEX on 27.02.16.
 */
public class ListPerformance {
    static Random random=new Random();
    static int reps=1000;
    static List<Test<List<Integer>>> tests=
            new ArrayList<Test<List<Integer>>>();
    static List<Test<LinkedList<Integer>>> qTests=
            new ArrayList<Test<LinkedList<Integer>>>();
    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i=0; i<loops; i++ ) {
                    list.clear();
                    for(int j=0; j<listSize; j++) {
                        list.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override

            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops * reps;
                int sizeSize=container.size();
                for(int i=0; i<loops; i++) {
                    container.get(random.nextInt(sizeSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++) {
                    container.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                final int LOOPS=100000;
                int half=container.size()/2;

                ListIterator<Integer> it=container.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                   it.add(47);

                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {

            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                for (int i = 0; i < loops; i++) {
                    container.add(5, 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size() > 5) {
                        container.remove(5);
                    }
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {

            
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {

                int loops=tp.loops;
                int size=tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("removeLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                    
                return 0;
            }
        });
    }
static class ListTester extends Tester<List<Integer>> {

    public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
        super(container, tests);
    }

    @Override
    protected List<Integer> initialize(int size) {
        container.clear();
        container.addAll(new CountingIntegerList(size));
        return container;
    }
    public static void run(List<Integer> list,List<Test<List<Integer>>> tests) {
        new ListTester(list, tests).timedTest();
    }


}
    public static void main(String[] args) {
            Tester<List<Integer>> arrayTest=new Tester<List<Integer>>(null, tests.subList(1, 3)) {

                @Override
                protected List<Integer> initialize(int size) {
                    Integer[] i=new Integer[size];
                    for (int j = 0; j < size; j++) {
                        i[j]=j;
                    }
                    return Arrays.asList(i);
                }
            };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();

        Tester.defaultParams= TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);

        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new Vector<Integer>(), tests);

        Tester<LinkedList<Integer>> qTest=
                new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        Tester.fieldWidth=12;
        qTest.setHeadline("Queue tests");
        qTest.timedTest();


    }
}
