package nl.vijfhart.ocp.generics_and_collections.uitwerking;

import java.util.Arrays;

class SorteerApp {

    public static void main(String args[]) {
        Integer[] getallen = new Integer[Integer.parseInt(args[0])];
        Arrays.setAll(getallen, i -> i * 2);
        Arrays.sort(getallen, (a, b) -> b > a ? 1 : b < a ? -1 : 0);
        System.out.println(Arrays.toString(getallen));
    }

}
