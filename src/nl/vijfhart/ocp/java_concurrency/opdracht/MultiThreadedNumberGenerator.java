package nl.vijfhart.ocp.java_concurrency.opdracht;

/*
Maak een multi-threaded applicatie die 10 random int getallen genereert.
De applicatie houdt bij wat de hoogste en de laagste waarde is, en stopt de gegenereerde getallen in een list.
Toon na afloop de inhoud van de list, en de hoogste en laagste waarde.

Tips:
Maak voor de hoogste en laagste waarde gebruik van twee AtomicInteger objecten, en gebruik
daarin de nieuwe Java 8 method accumulateAndGet() met een lambda expressie.
Gebruik een concurrent collectie voor de lijst.
 */

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedNumberGenerator {

    private static Random random = new Random();
    private static AtomicInteger hoogste = new AtomicInteger();
    private static AtomicInteger laagste = new AtomicInteger();
    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String... args) {
        try {
            ForkJoinPool pool = new ForkJoinPool();
            Factorial factorial = new Factorial(Integer.parseInt(args[0]));
            pool.invoke(factorial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("laagste: " + laagste);
            System.out.println("hoogste: " + hoogste);
            list.forEach(System.out::println);
            service.shutdown();
        }
    }

    private static class Factorial extends RecursiveAction {

        private static final int TRESHOLD = 2;
        private final long start, end;

        Factorial(long n) {
            this(1, n);
        }

        Factorial(long start, long end) {
            this.start = start;
            this.end = end;
            System.out.println("thread created");
        }

        @Override
        public void compute() {
            if (end - start <= TRESHOLD) {
                Random random = new Random();
                for (int x = 0; x <= end - start; x++) {
                    list.add(random.nextInt(Integer.MAX_VALUE));
                }
                hoogste.set(list.get(0));
                hoogste.set(list.stream().max((a, b) -> a.compareTo(b)).get());
                laagste.set(list.stream().min((a, b) -> a.compareTo(b)).get());
            } else {
                long mid = start + (end - start) / 2;
                Factorial f1 = new Factorial(start, mid);
                Factorial f2 = new Factorial(mid + 1, end);
                invokeAll(f1, f2);
            }
        }
    }

}

