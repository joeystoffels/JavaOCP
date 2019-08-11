package nl.vijfhart.ocp.java_concurrency.uitwerking;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MinMaxApp {

    private final static AtomicInteger min = new AtomicInteger(100);
    private final static AtomicInteger max = new AtomicInteger(0);
    private final static List<Integer> list = new CopyOnWriteArrayList<>();
    private final static Random random = new Random();

    public static void main(String args[]) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(5);
            try {
                for (int i = 0; i < 10; i++)
                    service.submit(() -> newValue());
            } finally {
                if (service != null) service.shutdown();
            }
            while (!service.isTerminated()) {
                service.awaitTermination(1, TimeUnit.SECONDS);
            }
            for (int val : list) {
                System.out.println(val);
            }
            System.out.println("min: " + min.get());
            System.out.println("max: " + max.get());
        } catch (InterruptedException ie) {
        }
    }

    private static void newValue() {
        int val = random.nextInt(100);
        min.updateAndGet(x -> val < x ? val : x);
        max.updateAndGet(x -> val > x ? val : x);
        list.add(val);
    }
}
