package nl.vijfhart.ocp.java_clazz_design.opdracht;

import java.util.ArrayList;
import java.util.List;

public final class Persoon {

    private final List<String> namen;

    Persoon(List<String> namen) {
        List<String> list = new ArrayList<>();
        list.addAll(namen);
        this.namen = list;
    }

    public List<String> getNamen() {
        List<String> list = new ArrayList<>();
        list.addAll(this.namen);
        return list;
    }

}
