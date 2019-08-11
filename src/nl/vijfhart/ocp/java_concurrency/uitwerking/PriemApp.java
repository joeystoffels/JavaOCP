package nl.vijfhart.ocp.java_concurrency.uitwerking;

/*
Verander de klasse concurrency/opdrachten/Priemgetal van een seriële naar een parallelle
implementatie gebruikmakend van het Fork/JoinPool framework: laat een thread hooguit 100
getallen verwerken (checken of het een priemgetal is), splits de taak anders op. Tips:
o Maak gebruik van een subclass van RecursiveAction
o Gebruik daarin een constructor waaraan twee grenswaarden worden
meegegeven
o Vul een concurrent List met de gevulde priemgetallen. Sorteer deze list na
afloop, om de priemgetallen daarna in de juiste volgorde te kunnen weergeven.
 */

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class PriemApp {

    private final static List<Long> priems = new CopyOnWriteArrayList<>();
    private final static ForkJoinPool fjp = new ForkJoinPool();

    public static void main(String args[]) {
        PriemGetal priem =
                new PriemGetal(
                        Long.parseLong(args[0]), Long.parseLong(args[1]));
        fjp.invoke(priem);
        Collections.sort(priems);
        for (long p : priems)
            System.out.println(p);
    }

    static class PriemGetal extends RecursiveAction {
        private final long start, einde, THRESHOLD = 100;

        PriemGetal(long start, long einde) {
            this.start = start;
            this.einde = einde;
        }

        public void compute() {
            if (einde - start <= THRESHOLD) {
                vul_priems(start, einde);
            } else {
                PriemGetal p1 = new PriemGetal(
                        start, start + (einde - start) / 2);
                PriemGetal p2 = new PriemGetal(
                        start + (einde - start) / 2, einde);
                invokeAll(p1, p2);
            }
        }

        public void vul_priems(long a, long b) {
            for (long i = a; i < b; i++) {
                if (isPriem(i)) {
                    priems.add(i);
                }
            }
        }

        private boolean isPriem(long getal) {
            if (getal == 1) return false;
            if (getal == 2) return true;
            if (getal % 2 == 0) return false;
            for (long deler = 3; deler <= Math.sqrt(getal); deler += 2) {
                if (getal % deler == 0) return false;
            }
            return true;
        }
    }
}
