package nl.vijfhart.ocp.java_concurrency.opdracht;

/*
Maak een parallel uitgevoerde applicatie in drie versies die 10 keer het gooien met een dobbelsteen simuleert.
De applicatie toont elke keer het aantal gegooide ogen, en geeft na afloop de melding “einde dobbelspel”.
Maak Dobbelspel1 met handmatig gestarte threads
Maak Dobbelspel2 met een ExecutorService die Callables start met submit()
(optioneel) Maak Dobbelspel3 met een ExecutorService die Callables start met behulp van invokeAll()
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadedDobbelsteenApp {

    private static ExecutorService service;
    private static Random random;
    private static int aantalWorpen;

    private static Callable<Integer> task;
    private static List<Future<Integer>> futures;
    private static List<Callable<Integer>> callables;

    public static void main(String... args) {
        initApp();

        try {
            versieEen();
            versieTwee();
            versieDrie();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (service != null) {
                service.shutdown();

                try {
                    while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
                        System.out.println("waiting...");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("einde dobbelspel");
        }

    }

    private static void versieEen() throws InterruptedException {
        futures = service.invokeAll(callables);
        futures.stream().forEach(MultiThreadedDobbelsteenApp::tryGetFuture);
    }

    private static void versieTwee() {
        callables.stream().forEach((x) -> futures.add(service.submit(x)));
        futures.stream().forEach(MultiThreadedDobbelsteenApp::tryGetFuture);
    }

    private static void versieDrie() {
        for (int x = 0; x <= aantalWorpen; x++) {
            service.execute(() -> System.out.println(gooiDobbelsteen()));
        }
    }

    private static void initApp() {
        service = Executors.newFixedThreadPool(5);
        random = new Random();
        aantalWorpen = 10;

        task = () -> gooiDobbelsteen();
        futures = new ArrayList<>();
        callables = new ArrayList<>();

        for (int i = 0; i < aantalWorpen; i++) {
            callables.add(task);
        }
    }

    private static Integer gooiDobbelsteen() {
        return random.nextInt(6) + 1;
    }

    private static Integer tryGetFuture(Future<Integer> future) {
        try {
            Integer value = future.get();
            System.out.println(value);
            return value;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
