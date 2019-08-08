package nl.vijfhart.ocp.java_concurrency.uitwerking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Dobbelspel2 {

    public static void main(String args[]) {
        Random random = new Random();
        List<Future<Integer>> list = new ArrayList<>();
        try {
            ExecutorService service = Executors.newFixedThreadPool(4);
            try {
                for (int i = 0; i <= 10; i++) {
                    Future<Integer> future = service.submit(() -> random.nextInt(6) + 1);
                    list.add(future);
                }
            } finally {
                if (service != null) service.shutdown();
            }
            while (!service.isTerminated()) {
                service.awaitTermination(1, TimeUnit.SECONDS);
            }
            for (Future<Integer> future : list) {
                System.out.println(future.get());
            }
            System.out.println("Einde dobbelspel");
        } catch (InterruptedException | ExecutionException e) {
        }
    }

}
