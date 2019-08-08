package nl.vijfhart.ocp.java_concurrency.uitwerking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Dobbelspel3 {

    public static void main(String args[]) {
        List<Future<Integer>> futures = null;
        Random random = new Random();
        try {
            ExecutorService service = Executors.newFixedThreadPool(4);
            try {
                List<Callable<Integer>> callables = new ArrayList<>();
                for (int i = 0; i <= 10; i++) {
                    callables.add(() -> random.nextInt(6) + 1);
                }
                futures = service.invokeAll(callables);
            } finally {
                if (service != null) service.shutdown();
            }
            while (!service.isTerminated()) {
                service.awaitTermination(1, TimeUnit.SECONDS);
            }
            for (Future<Integer> future : futures) {
                System.out.println(future.get());
            }
            System.out.println("Einde dobbelspel");
        } catch (InterruptedException | ExecutionException e) {
        }
    }

}
