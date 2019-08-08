package nl.vijfhart.ocp.java_concurrency.uitwerking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Dobbelspel1 {

    public static void main(String args[]) {
        Random random = new Random();
        List<Thread> taken = new ArrayList<>();
        try {
            for (int i = 0; i <= 10; i++) {
                taken.add(new Thread(() -> System.out.println(random.nextInt(6) + 1)));
            }
            for (Thread t : taken) {
                t.start();           // eerst alle threads parallel starten ...
            }
            for (Thread t : taken) {
                t.join();            // ... dan pas wachten tot ze klaar zijn
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Einde dobbelspel");
    }

}
