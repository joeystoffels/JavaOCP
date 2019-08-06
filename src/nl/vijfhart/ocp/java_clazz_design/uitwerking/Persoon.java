package nl.vijfhart.ocp.java_clazz_design.uitwerking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Persoon {

    final private List<String> namen = new ArrayList<>();

    Persoon(List<String> namen) {
        namen = new ArrayList<>(namen);
    }

    public List<String> getNamen() {
        return Collections.unmodifiableList(namen);
        // of: return new ArrayList<>(namen);
    }

}
