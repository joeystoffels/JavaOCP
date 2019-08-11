package nl.vijfhart.ocp.java_io_nio_2_fundamentals.uitwerking;

import java.io.File;

class DirApp {

    public static void main(String args[]) {
        File file = new File("./a/b/c/d");

        if (file.mkdirs()) {
            System.out.println(file);
        }

        file.delete();

        while ((file = file.getParentFile()) != null) {
            System.out.println(file);
            file.delete();
        }

        System.out.println(file);
    }

}
