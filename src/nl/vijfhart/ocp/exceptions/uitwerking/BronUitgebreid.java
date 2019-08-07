package nl.vijfhart.ocp.exceptions.uitwerking;

import java.io.IOException;

class BronUitgebreid implements AutoCloseable {
    private String name;

    BronUitgebreid(String name) {
        this.name = name;
    }

    public void open() throws IOException {
        System.out.println("opening " + name);
        throw new IOException("error wile opening");
    }

    public void close() throws IOException {
        System.out.println("closing " + name);
        throw new IOException("error while closing");
    }

    public String toString() {
        return name;
    }
}
