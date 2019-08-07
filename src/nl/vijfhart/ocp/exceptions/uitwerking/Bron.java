package nl.vijfhart.ocp.exceptions.uitwerking;

public class Bron implements AutoCloseable {
    private String name;

    Bron(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("opening " + name);
    }

    public void close() {
        System.out.println("closing " + name);
    }

    public String toString() {
        return name;
    }
}
