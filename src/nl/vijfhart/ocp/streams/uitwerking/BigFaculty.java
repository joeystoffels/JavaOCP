package nl.vijfhart.ocp.streams.uitwerking;

import java.math.BigInteger;

class BigFaculty {
    private BigInteger value = BigInteger.ONE;

    public void multiply(BigInteger other) {
        this.value = this.value.multiply(other);
    }

    public void combine(BigFaculty other) {
        this.value = this.value.multiply(other.value);
    }

    public String toString() {
        return value.toString();
    }

}
