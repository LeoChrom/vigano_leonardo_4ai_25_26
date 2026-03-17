public class Calcolatrice {

    public int somma(int a, int b) {
        return a + b;
    }

    public int sottrazione(int a, int b) {
        return a - b;
    }

    public int moltiplicazione(int a, int b) {
        return a * b;
    }

    public double divisione(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisione per zero non permessa");
        }
        return (double) a / b;
    }
}